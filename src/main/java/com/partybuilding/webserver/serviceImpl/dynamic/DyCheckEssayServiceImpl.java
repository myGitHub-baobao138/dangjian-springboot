package com.partybuilding.webserver.serviceImpl.dynamic;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.dynamic.DynamicCheckEssayMapper;
import com.partybuilding.webserver.dao.system.SysOperationLogMapper;
import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.dynamic.essay.*;
import com.partybuilding.webserver.entity.system.SysOperationLog;
import com.partybuilding.webserver.service.dynamic.DyCheckEssayService;
import com.partybuilding.webserver.util.PageResult;
import com.partybuilding.webserver.util.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DyCheckEssayServiceImpl implements DyCheckEssayService{

    @Autowired(required = false)
    private DynamicCheckEssayMapper checkEssayMapper;

    @Autowired(required = false)
    private SysOperationLogMapper operationLogMapper;

    /**
     * 以判断此管理员是2级组织
     * 根据管理员所属组织id
     * 去获取稿件信息列表
     * **/
    @Override
    public JsonResult getCheckEssayListByRankAndOrganization(AllEssaysListDto getListDto) {
        //判断参数是否有误
        int currentPage = checkCurrentPage(getListDto.getCurrentPage());
        int pageSize = checkPageSize(getListDto.getPageSize());

        JsonResult jsonResult = new JsonResult();
        PageHelper.startPage(currentPage, pageSize);

        List<EssayDto> allEssayList =  checkEssayMapper.getCheckEssayListByRankAndOrganization(
                getListDto.getOrganizationId(),getListDto.getOrganizationRank());

        // 获取分页查询后的数据
        PageInfo<EssayDto> pageInfo = new PageInfo<>(allEssayList);
        // 封装需要返回的分页实体
        PageResult<EssayDto> result = new PageResult<EssayDto>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(allEssayList);

        jsonResult.setData(result);
        return jsonResult;
    }

    /**
     * 根据稿件id去获取稿件具体信息
     * **/
    @Override
    public JsonResult getEssayDetails(String essayId) {
        JsonResult jsonResult = new JsonResult();

        EssayDetailsDto essayDetailsDto = checkEssayMapper.getEssayDetails(essayId);
        System.out.println(essayDetailsDto.getCheckStatus());

        essayDetailsDto.setContent( formatContent(essayDetailsDto.getContent()));

        jsonResult.setData(essayDetailsDto);
        return jsonResult;
    }

    /**
     * 审核稿件
     * 根据稿件id
     * 修改审核状态/审核时间/审核说明/审核人id
     * **/
    @Override
    public JsonResult updateEssayBySingleEssayId( CheckFormDto checkFormDto) {
        JsonResult jsonResult = new JsonResult();

        //SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd");
        //操作时间
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        checkFormDto.setCheckTime(timeStamp);
        //System.out.println(formatter.format(checkTime));
        int isSuccess = checkEssayMapper.updateEssayBySingleEssayId(
                checkFormDto.getCheckedEssayId(), checkFormDto.getCheckStatus(),
                checkFormDto.getCheckerId(), checkFormDto.getCheckTime(), checkFormDto.getDetails());

        if(isSuccess >0){
            jsonResult.setMessage("单篇稿件审核成功");
            jsonResult.setCode(200);

            SysOperationLog operationLog = this.getCheckSingleFormLog(checkFormDto);

            this.insertCheckSingleLog(operationLog);

        }else{
            jsonResult.setMessage("单篇稿件审核失败");
            jsonResult.setCode(500);
        }
        return jsonResult;
    }

    /**
     * 批量审核稿件
     * 根据稿件id列表
     * 修改审核状态/审核时间/审核说明/审核人id
     * **/
    @Override
    public JsonResult updateManyEssayByEssayIdList(CheckFormDto checkFormListDto) {
        JsonResult jsonResult = new JsonResult();


        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        checkFormListDto.setCheckTime(timeStamp);

        int isSuccess = checkEssayMapper.updateManyEssayByEssayIdList(checkFormListDto);

        if(isSuccess >0){
            jsonResult.setMessage("批量稿件审核成功");
            jsonResult.setCode(200);

            List<SysOperationLog> operationLogs = this.getManyCheckFormLogs(checkFormListDto);

            this.insertManyCheckLogs(operationLogs);

        }else{
            jsonResult.setMessage("批量稿件审核失败");
            jsonResult.setCode(500);
        }
        return jsonResult;
    }




    /**
     * 查询稿件列表
     * 根据输入内容
     * 通过 标题/内容/投稿人/审核人
     * **/
    @Override
    public JsonResult queryCheckEssayListByInputContent(QueryEssayBodyDto queryBodyDto) {

        //判断参数是否有误
        int currentPage = this.checkCurrentPage(queryBodyDto.getCurrentPage());
        int pageSize = this.checkPageSize(queryBodyDto.getPageSize());

        JsonResult jsonResult = new JsonResult();
        PageHelper.startPage(currentPage, pageSize);

        String queryInputContent = queryBodyDto.getInputContent();
        StringBuilder stringBuilder = new StringBuilder("%");
        for(int i=0; i<queryInputContent.length();i++){
            stringBuilder.append(queryInputContent.charAt(i));
            stringBuilder.append("%");
        }
        String newInputContent = stringBuilder.toString();

        List<EssayDto> queryEssayList =  checkEssayMapper.queryCheckEssayListByInputContent(
                newInputContent, queryBodyDto.getOrganizationId(),queryBodyDto.getOrganizationRank());

        // 获取分页查询后的数据
        PageInfo<EssayDto> pageInfo = new PageInfo<>(queryEssayList);
        // 封装需要返回的分页实体
        PageResult<EssayDto> result = new PageResult<EssayDto>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(queryEssayList);

        jsonResult.setData(result);
        return jsonResult;
    }

    /**
     * 查询稿件列表
     * 根据输入内容
     * 判断 输入的 来源（党员先锋/基层风采/党主题日）
     * 进行查询
     * **/
    @Override
    public JsonResult queryCheckEssayListBySource(QueryEssayBodyDto queryBodyDto) {

        //判断参数是否有误
        //判断参数是否有误
        int currentPage = this.checkCurrentPage(queryBodyDto.getCurrentPage());
        int pageSize = this.checkPageSize(queryBodyDto.getPageSize());

        JsonResult jsonResult = new JsonResult();
        PageHelper.startPage(currentPage, pageSize);


        List<EssayDto> queryEssayList =  checkEssayMapper.queryCheckEssayListBySource(
                queryBodyDto.getSource(), queryBodyDto.getOrganizationId(),queryBodyDto.getOrganizationRank());

        // 获取分页查询后的数据
        PageInfo<EssayDto> pageInfo = new PageInfo<>(queryEssayList);
        // 封装需要返回的分页实体
        PageResult<EssayDto> result = new PageResult<EssayDto>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(queryEssayList);

        jsonResult.setData(result);
        return jsonResult;
    }

    /**
     * 查询稿件列表
     * 根据审核状态
     * 进行查询
     * **/
    @Override
    public JsonResult queryCheckEssayListByCheckStatus(QueryEssayBodyDto queryBodyDto) {

        //判断参数是否有误
        int currentPage = this.checkCurrentPage(queryBodyDto.getCurrentPage());
        int pageSize = this.checkPageSize(queryBodyDto.getPageSize());

        JsonResult jsonResult = new JsonResult();
        PageHelper.startPage(currentPage, pageSize);

        List<EssayDto> queryEssayList =  checkEssayMapper.queryCheckEssayListByCheckStatus(
                queryBodyDto.getCheckStatus(), queryBodyDto.getOrganizationId(),queryBodyDto.getOrganizationRank());

        // 获取分页查询后的数据
        PageInfo<EssayDto> pageInfo = new PageInfo<>(queryEssayList);
        // 封装需要返回的分页实体
        PageResult<EssayDto> result = new PageResult<EssayDto>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(queryEssayList);

        jsonResult.setData(result);
        return jsonResult;
    }

    /**
     * 查询稿件列表
     * 根据审核状态
     * 和输入内容（标题/内容/投稿人/审核人）
     * 进行查询
     * **/
    @Override
    public JsonResult queryCheckEssayListByCheckAndInput(QueryEssayBodyDto queryBodyDto) {
        //判断参数是否有误
        int currentPage = this.checkCurrentPage(queryBodyDto.getCurrentPage());
        int pageSize = this.checkPageSize(queryBodyDto.getPageSize());

        JsonResult jsonResult = new JsonResult();
        PageHelper.startPage(currentPage, pageSize);

        String inputContent = queryBodyDto.getInputContent();
        StringBuilder stringBuilder = new StringBuilder("%");
        for(int i=0; i<inputContent.length();i++){
            stringBuilder.append(inputContent.charAt(i));
            stringBuilder.append("%");
        }
        String newInputContent = stringBuilder.toString();

        List<EssayDto> queryEssayList = checkEssayMapper.queryCheckEssayListByCheckStatusAndInputContent(
                newInputContent,queryBodyDto.getCheckStatus(),
                queryBodyDto.getOrganizationId(),queryBodyDto.getOrganizationRank());

        // 获取分页查询后的数据
        PageInfo<EssayDto> pageInfo = new PageInfo<>(queryEssayList);
        // 封装需要返回的分页实体
        PageResult<EssayDto> result = new PageResult<EssayDto>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(queryEssayList);

        jsonResult.setData(result);
        return jsonResult;
    }

    /**
     *
     * 查询稿件列表
     * 根据 稿件来源
     * 和审核状态
     * 进行查询
     */
    @Override
    public JsonResult queryCheckEssayListByCheckAndSource(QueryEssayBodyDto queryBodyDto) {
        //判断参数是否有误
        int currentPage = this.checkCurrentPage(queryBodyDto.getCurrentPage());
        int pageSize = this.checkPageSize(queryBodyDto.getPageSize());

        JsonResult jsonResult = new JsonResult();
        PageHelper.startPage(currentPage, pageSize);

        List<EssayDto> queryEssayList = checkEssayMapper.queryCheckEssayListByCheckStatusAndSource(
                queryBodyDto.getSource(),queryBodyDto.getCheckStatus(),
                queryBodyDto.getOrganizationId(),queryBodyDto.getOrganizationRank());

        // 获取分页查询后的数据
        PageInfo<EssayDto> pageInfo = new PageInfo<>(queryEssayList);
        // 封装需要返回的分页实体
        PageResult<EssayDto> result = new PageResult<EssayDto>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(queryEssayList);

        jsonResult.setData(result);
        return jsonResult;
    }



    //新增一条审核操作记录
    @Transactional
    public void insertCheckSingleLog(SysOperationLog operationLog) {
        operationLogMapper.insertSelective(operationLog);
    }

    //新增批量审核操作记录
    @Transactional
    public void insertManyCheckLogs(List<SysOperationLog> operationLogs) {
        operationLogMapper.insertManyLogs(operationLogs);
    }

    //获取审核单篇稿件的日志内容拼接
    private SysOperationLog getCheckSingleFormLog(CheckFormDto checkFormDto) {
        SysOperationLog singleLog = new SysOperationLog();

        //操作日志id
        singleLog.setId(Uuid.getUuid());

        //操作时间
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        singleLog.setOperationTime(timeStamp);

        //操作页面
        singleLog.setOperationPage("稿件审核管理");

        //操作人id
        singleLog.setPartyId(checkFormDto.getCheckerId());

        //操作内容
        String operatorName = checkFormDto.getCheckerName();
        String essayName = checkFormDto.getCheckedEssayName();

        StringBuilder stringBuilder = new StringBuilder(operatorName);
        stringBuilder.append("审核");
        if(checkFormDto.getCheckStatus() == -1){
            stringBuilder.append("不通过");
        }else{
            stringBuilder.append("通过");
        }
        stringBuilder.append(essayName);
        String operateContent = stringBuilder.toString();

        singleLog.setOperationContent(operateContent);

        return singleLog;
    }

    //获取审核批量稿件的日志内容拼接
    private List<SysOperationLog> getManyCheckFormLogs(CheckFormDto checkFormListDto) {

        List<SysOperationLog> logs = new ArrayList<>();

        for(int i=0; i<checkFormListDto.getCheckedIdList().size(); i++){
            SysOperationLog log = new SysOperationLog();

            //操作时间
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            log.setOperationTime(timeStamp);

            //操作页面
            log.setOperationPage("稿件审核管理");

            //操作人id
            log.setPartyId(checkFormListDto.getCheckerId());

            log.setId(Uuid.getUuid());

            //操作人姓名
            StringBuilder stringBuilder = new StringBuilder(checkFormListDto.getCheckerName());
            stringBuilder.append("审核");
            if(checkFormListDto.getCheckStatus() == -1){
                stringBuilder.append("不通过");
            }else{
                stringBuilder.append("通过");
            }
            stringBuilder.append(checkFormListDto.getCheckedNameList().get(i));

            String operateContent = stringBuilder.toString();
            log.setOperationContent(operateContent);

            logs.add(log);
        }
        return logs;
    }
    //判断传入的当前页是否有错
    private int checkCurrentPage(int currentPage) {
        if(currentPage <=0){
            return 0;
        }
        return currentPage;
    }

    //判断传入的页码
    private int checkPageSize(int pageSize) {
        if(pageSize <=0 ){
            return 5;
        }
        return pageSize;
    }

    //查看稿件详情--调整文章样式
    private String formatContent(String content) {
        content = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + content;
        content = content.replaceAll(" ", "&nbsp;");
        content = content.replaceAll("\n", "<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        return content;
    }
}
