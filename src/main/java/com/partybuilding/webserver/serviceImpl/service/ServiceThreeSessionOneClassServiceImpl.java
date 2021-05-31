package com.partybuilding.webserver.serviceImpl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.service.ServiceThreeSessionOneClassMapper;
import com.partybuilding.webserver.dto.service.themeDay.ThemeDayPartyMemberNumberDTO;
import com.partybuilding.webserver.dto.service.threeSessionOneClass.*;
import com.partybuilding.webserver.entity.service.ServiceParticipateThreeSessionOneClass;
import com.partybuilding.webserver.entity.service.ServiceThreeSessionOneClass;
import com.partybuilding.webserver.service.service.ServiceThreeSessionOneClassService;
import com.partybuilding.webserver.util.PageResult;
import com.partybuilding.webserver.util.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Description: 三会一课管理
 */

@Service
public class ServiceThreeSessionOneClassServiceImpl implements ServiceThreeSessionOneClassService {

    @Autowired(required = false)
    ServiceThreeSessionOneClassMapper serviceThreeSessionOneClassMapper;

    String theeOneId;

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(ServiceThreeSessionOneClass record) {
        record.setId(Uuid.getUuid());
        return serviceThreeSessionOneClassMapper.insert(record);
    }

    @Override
    public int insertSelective(ServiceThreeSessionOneClass record) {
        theeOneId = Uuid.getUuid();
        record.setId(theeOneId);
        return serviceThreeSessionOneClassMapper.insertSelective(record);
    }

    @Override
    public ServiceThreeSessionOneClass selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int deleteThreeOne(String id) {
        return serviceThreeSessionOneClassMapper.deleteThreeOne(id);
    }

    @Override
    public int postThreeOne(String[] ids) {
        return serviceThreeSessionOneClassMapper.postThreeOne(ids);
    }
    /**
     * @param threeOneDTO
     * @return 当前账户下可查看的所有三会一课
     */
    @Override
    public PageResult<ThreeSessionOnClassDTO> getThreeSessionOneClassList(ThreeOneQueryDTO threeOneDTO) {
        //  判断参数是否有误
        if(threeOneDTO.getCurrentPage() <= 0){
            threeOneDTO.setCurrentPage(1);  //设置默认当前页
        }
        if(threeOneDTO.getPageSize() <= 0) {
            threeOneDTO.setPageSize(5); // 默认每页5条
        }
        PageHelper.startPage(threeOneDTO.getCurrentPage(),threeOneDTO.getPageSize());
        List<ThreeSessionOnClassDTO> lists = serviceThreeSessionOneClassMapper.getThreeSessionOneClassList(threeOneDTO);

        // 获取分页查询后的3 1
        PageInfo<ThreeSessionOnClassDTO> pageInfo = new PageInfo<>(lists);
        // 封装需要返回的分页实体
        PageResult<ThreeSessionOnClassDTO> result = new PageResult<ThreeSessionOnClassDTO>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(lists);

        return result;
    }

    @Override
    public ThreeSessionOnClassDTO getThreeOneDetail(String id) {
        return this.serviceThreeSessionOneClassMapper.getThreeOneDetail(id);
    }

    @Override
    public List<ParticipateReturnDTO> getNotAttendIdList(ParticipateDTO record) {
        return serviceThreeSessionOneClassMapper.getNotAttendIdList(record);
    }

    @Override
    public List<String> getAttendIdList(String id) {
        return serviceThreeSessionOneClassMapper.getAttendIdList(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ServiceThreeSessionOneClass record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(ServiceThreeSessionOneClass record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ServiceThreeSessionOneClass record) {
        return serviceThreeSessionOneClassMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ParticipateReturnDTO> getPartyMemberListByOrganizationId(String organizationId) {
        return serviceThreeSessionOneClassMapper.getPartyMemberListByOrganizationId(organizationId);
    }

    @Override
    public int insertAttendThreeOne(List<ServiceParticipateThreeSessionOneClass> record) {

        for(ServiceParticipateThreeSessionOneClass s:record){
            s.setId(Uuid.getUuid());
        }
        return serviceThreeSessionOneClassMapper.insertAttendThreeOne(record);
    }

    @Override
    public int deleteParticipatesThreeOne(String threeOneId){
        return serviceThreeSessionOneClassMapper.deleteParticipatesThreeOne(threeOneId);
    }

    @Override
    public  List<ParticipateReturnDTO> getParticipateList(String threeOneId) {
        return serviceThreeSessionOneClassMapper.getParticipateList(threeOneId);
    }

}
