package com.partybuilding.webserver.serviceImpl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.service.ServiceVoteMapper;
import com.partybuilding.webserver.dao.service.ServiceVoteOptionMapper;
import com.partybuilding.webserver.dao.system.SysOrganizationalStructureMapper;
import com.partybuilding.webserver.dao.system.SysPartyMemberInformationMapper;
import com.partybuilding.webserver.dao.system.SysUserMapper;
import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.service.voteDto.*;
import com.partybuilding.webserver.entity.message.MessageDTO;
import com.partybuilding.webserver.entity.service.ServiceVote;
import com.partybuilding.webserver.entity.service.ServiceVoteOption;
import com.partybuilding.webserver.schedule.RabbitProduct;
import com.partybuilding.webserver.service.service.ServiceVoteService;
import com.partybuilding.webserver.util.PageResult;
import com.partybuilding.webserver.util.Uuid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * 投票调查service实现类
 */
@Transactional
@Service
public class ServiceVoteServiceImpl implements ServiceVoteService {

    private SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

    @Autowired
    private SysOrganizationalStructureMapper structureMapper;

    @Autowired
    private RabbitProduct rabbitConsultProduct;

    @Autowired
    SysPartyMemberInformationMapper partyMapper;

    @Autowired
    ServiceVoteMapper serviceVoteMapper;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    ServiceVoteOptionMapper optionMapper;

    @Override
    public int deleteByPrimaryKey(String voteId) {
        return serviceVoteMapper.deleteByPrimaryKey(voteId);
    }

    @Override
    public int insert(ServiceVoteDto record) {
        return 0;
    }

    /**
     *
     * @param record
     * @return
     * @throws ParseException
     */
    @Override
    public JsonResult insertSelective(AddVoteDto record) throws ParseException {
        String uuid = UUID.randomUUID().toString();
        ServiceVote serviceVote = null;
        //对象映射
        serviceVote = modelMapper.map(record,ServiceVote.class);
        serviceVote.setVoteId(uuid.replaceAll("-",""));
        List<ServiceVoteOption> serviceVoteOptions =  new LinkedList<>();
        for(ServiceVoteOption serviceVoteOption:record.getVoteOption()){
            serviceVoteOption.setId(Uuid.getUuid());
            serviceVoteOption.setVoteId(serviceVote.getVoteId());
            serviceVoteOptions.add(serviceVoteOption);
        }
        int successOption = optionMapper.insertList(serviceVoteOptions);
        int successVote = serviceVoteMapper.insert(serviceVote);
        JsonResult jsonResult = new JsonResult();
        if(successOption>0&&successVote>0){
            jsonResult.setCode(200);
            jsonResult.setMessage("投票调查发布成功");
            //1查找管理员等级
            Integer rank = structureMapper.selectRank(serviceVote.getOrganizationId());
            List<String> partyList = new LinkedList<>();
            //根据管理员等级查找该组织下面的党员id
            if (rank>1){
                //二级组织及以下
                partyList = partyMapper.selectPartyByOrganizationId(serviceVote.getOrganizationId());
            }else {
                //一级组织
                partyList = partyMapper.selectAllPartyByOrganizationId(serviceVote.getOrganizationId());
            }
            //获取消息通知人的id
            //发送消息
//            MessageDTO messageDTO = new MessageDTO();
//            messageDTO.setMessageType("1");
//            messageDTO.setMessageTitle("投票调查结束通知");
//            messageDTO.setMessageContent("您有投票调查30分钟后结束，请抓紧时间前往投票，投票时间"+df.format(serviceVote.getVoteBeginTime())+"-----"+df.format(serviceVote.getVoteEndTime()));
//            messageDTO.setId(Uuid.getUuid());
//            messageDTO.setMessageObjects(partyList);
//            messageDTO.setPartyId(serviceVote.getSysUserPartyId());
//            //提前半个小时提醒投票结束
//            long time = serviceVote.getVoteEndTime().getTime()-30*60*1000-serviceVote.getVoteBeginTime().getTime();
//            rabbitConsultProduct.sendDelayMessage(time,messageDTO);
        }else {
            jsonResult.setCode(500);
            jsonResult.setMessage("投票调查发布失败，请稍后重试");
        }
//        //将list转换成字符串存到数据库
//        String json = null;
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            json = objectMapper.writeValueAsString(record.getVoteOption());
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        serviceVote.setStrVoteOption(json);
        record = null;
        return jsonResult;
    }

    @Override
    public ServiceVote selectByPrimaryKey(String voteId) {
        return null;
    }

    @Override
    public JsonResult updateByPrimaryKeySelective(AddVoteDto record) {
        ServiceVote serviceVote = null;
        //对象映射,要修改的vote 记录
        serviceVote = modelMapper.map(record,ServiceVote.class);
        List<ServiceVoteOption> serviceVoteOptions = record.getVoteOption();
        //无id，不能修改的选项，添加新的选项信息
        List<ServiceVoteOption> addVoteOptions = new LinkedList<>();
        //有id，可以修改的选项信息
        List<ServiceVoteOption> updateVoteOptions = new LinkedList<>();
        for (ServiceVoteOption serviceVoteOption:serviceVoteOptions){
            serviceVoteOption.setVoteId(serviceVote.getVoteId());
            if (("").equals(serviceVoteOption.getId())||serviceVoteOption.getId()==null){
                serviceVoteOption.setId(Uuid.getUuid());
                addVoteOptions.add(serviceVoteOption);
            }else {
                updateVoteOptions.add(serviceVoteOption);
            }
        }
        JsonResult jsonResult = new JsonResult();
        if(addVoteOptions.size()>0){
            int insertSuccess = optionMapper.insertList(addVoteOptions);
            if (insertSuccess>0){
                jsonResult.setMessage("修改成功！");
                jsonResult.setCode(200);
            }else {
                jsonResult.setMessage("修改失败");
                jsonResult.setCode(500);
            }
        }

        int updateSuccess=serviceVoteMapper.updateByPrimaryKey(serviceVote);
        int updateOptionSuccess = optionMapper.updateVote(updateVoteOptions);
        if(updateOptionSuccess>0&&updateSuccess>0){
            jsonResult.setMessage("修改成功！");
            jsonResult.setCode(200);
        }else {
            jsonResult.setMessage("修改失败");
            jsonResult.setCode(500);
        }
        return jsonResult;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(ServiceVote record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ServiceVote record) {
        return 0;
    }

    /**
     * 根据投票调查的标题模糊查找投票信息
     * @param pageAndTitle
     * @return
     */
    @Override
    public JsonResult selectByTitle(ServiceVoteSelectByTitleDto pageAndTitle) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setMessage("fail");
        jsonResult.setData("-1");
        PageHelper.startPage(pageAndTitle.getCurrentPage(),pageAndTitle.getPageSize());
        //如果管理员是校级用户，则查询所有的投票信息
//        if(sysUser.getSchool()){
//            List<ServiceVoteDto> serviceVoteDtoList = serviceVoteMapper.selectByTitle(pageAndTitle.getTitle());
//            PageResult<ServiceVoteDto> result = getPageResult(serviceVoteDtoList);
//            jsonResult.setMessage("查询成功");
//            jsonResult.setData(result);
//            return jsonResult;
//            //如果管理员是院级用户，则查找该学院的投票信息
//        }else {
//            List<ServiceVoteDto> serviceVoteDtoList = serviceVoteMapper.selectVoteByTitleAndAcademy(pageAndTitle.getTitle(),sysUser.getAcademyId());
//            PageResult<ServiceVoteDto> result = getPageResult(serviceVoteDtoList);
//            jsonResult.setMessage("查询成功");
//            jsonResult.setData(result);
//            return jsonResult;
//        }
        return jsonResult;
    }

    /**
     * 根据管理员的院校级别以及投票信息状态查询数据
     * @param status
     * @param pageInputDTO
     * @return
     */
    @Override
    public JsonResult selectVoteByStatus(Integer status, PageInputDTO pageInputDTO) {
        JsonResult jsonResult = new JsonResult();
//        jsonResult.setMessage("fail");
//        jsonResult.setData("-1");
//        if(sysUser.getSchool()){
//            PageHelper.startPage(pageInputDTO.getCurrentPage(),pageInputDTO.getPageSize());
//            List<ServiceVoteDto> serviceVoteDtos = serviceVoteMapper.selectVoteByStatus(status);
//            PageResult<ServiceVoteDto> result = getPageResult(serviceVoteDtos);
//            jsonResult.setData(result);
//            jsonResult.setMessage("查询成功!");
//            return jsonResult;
//        }else {
//            PageHelper.startPage(pageInputDTO.getCurrentPage(),pageInputDTO.getPageSize());
//            StatusAndAcademy statusAndAcademy = new StatusAndAcademy();
//            statusAndAcademy.setStatus(status);
//            statusAndAcademy.setAcademy(sysUser.getAcademyId());
//            List<ServiceVoteDto> serviceVoteDtos = serviceVoteMapper.selectVoteByStatusAndAcademy(statusAndAcademy);
//            PageResult<ServiceVoteDto> result = getPageResult(serviceVoteDtos);
//            jsonResult.setData(result);
//            jsonResult.setMessage("查询成功!");
//            return jsonResult;
//        }
        return jsonResult;
    }
    @Override
    public PageResult<ServiceVoteDto> selectVoteByBeginTime(Date beginTime, PageInputDTO pageInputDTO) {
//        GetCurrentUserInfoDTO sysUser = sysUserMapper.getCurrentUserInfoByUserId(pageInputDTO.getPartyId());
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
//        String time = df.format(beginTime);
//        PageHelper.startPage(pageInputDTO.getCurrentPage(),pageInputDTO.getPageSize());
//        List<VoteInfoListDto> serviceVoteDtos = serviceVoteMapper.selectVoteByBeginTime(time);
//        PageResult<ServiceVoteDto> result = getPageResult(serviceVoteDtos);
        return null;
    }

    /**
     * 根据不同的条件查询投票调查数据
     * @param selectByTitleOrTimeOrStatusDto
     * @return
     */
    @Override
    public JsonResult selectByTitleAndTimeAndStatus(SelectByTitleOrTimeOrStatusDto selectByTitleOrTimeOrStatusDto) {
        JsonResult jsonResult = new JsonResult();
        PageHelper.startPage(selectByTitleOrTimeOrStatusDto.getCurrentPage(),selectByTitleOrTimeOrStatusDto.getPageSize());

        //对象映射,相同的数据映射过去
        List<GetVoteInfoListDto> listDtos = serviceVoteMapper.selectByTitleOrTimeOrStatus(selectByTitleOrTimeOrStatusDto);
        PageResult result = getPageResult(listDtos);
        listDtos = result.getList();
        StringBuilder option= new StringBuilder();
        List<VoteInfoListDto> list = modelMapper.map(listDtos, new TypeToken<List<VoteInfoListDto>>(){}.getType());
        //将对象的选项分开并且找到最多投票记录的那个选项
        for(int i=0;i<listDtos.size();i++){
            String maxOption="";
            if (listDtos.get(i).getList().size()!=0) {
                if (listDtos.get(i).getList().get(0).getOption() != null) {
                    maxOption = listDtos.get(i).getList().get(0).getOption();
                }

                for (int j = 0; j < listDtos.get(i).getList().size(); j++) {
                    option.append(listDtos.get(i).getList().get(j).getOption()).append("、");
                    if (j + 1 < listDtos.get(i).getList().size()) {
                        if (listDtos.get(i).getList().get(j).getOptionNumber() < listDtos.get(i).getList().get(j + 1).getOptionNumber()) {
                            maxOption = listDtos.get(i).getList().get(j + 1).getOption();
                        }
                    }
                }
                option.deleteCharAt(option.length() - 1);
                list.get(i).setOption(option.toString());
                list.get(i).setMaxOption(maxOption);
                maxOption = "";
                list.get(i).setNoSubTime(listDtos.get(i).getBeginTime().replaceAll("/","-") + "*" + listDtos.get(i).getEndTime().replaceAll("/","-"));
//            list.get(i).setNoSubTime(list.get(i).getNoSubTime().replaceAll("/","-"));
                list.get(i).setBeginTimeAndEndTime(listDtos.get(i).getBeginTime().substring(0, 10) + "-" + listDtos.get(i).getEndTime().substring(0, 10));
                option.delete(0, option.length());
            }
        }
        result.setList(list);
        jsonResult.setMessage("获取数据成功");
        jsonResult.setData(result);
        return jsonResult;
    }


    /**
     * 分页封装
     * @param voteInfoListDto
     * @return
     */
    public PageResult<GetVoteInfoListDto> getPageResult(List<GetVoteInfoListDto> voteInfoListDto){
        PageInfo<GetVoteInfoListDto> pageInfo = new PageInfo<GetVoteInfoListDto>(voteInfoListDto);
        // 封装需要返回的分页实体
        PageResult<GetVoteInfoListDto> result = new PageResult<GetVoteInfoListDto>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(pageInfo.getList());
        return result;
    }
}
