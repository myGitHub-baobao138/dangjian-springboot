package com.partybuilding.webserver.serviceImpl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.service.ServiceMinuteMeetingMapper;
import com.partybuilding.webserver.dto.service.threeSessionOneClass.ServiceMinuteMeetingDTO;
import com.partybuilding.webserver.dto.service.threeSessionOneClass.ServiceMinuteMeetingQueryDTO;
import com.partybuilding.webserver.entity.service.ServiceMinuteMeeting;
import com.partybuilding.webserver.service.service.ServiceMinuteMeetingService;
import com.partybuilding.webserver.util.PageResult;
import com.partybuilding.webserver.util.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMinuteMeetingServiceImpl implements ServiceMinuteMeetingService {
    @Autowired(required = false)
    ServiceMinuteMeetingMapper serviceMinuteMeetingMapper;

    @Override
    public int insert(ServiceMinuteMeeting record) {
        record.setId(Uuid.getUuid());
        return serviceMinuteMeetingMapper.insert(record);
    }

    @Override
    public int insertSelective(ServiceMinuteMeeting record) {
        record.setId(Uuid.getUuid());
        return serviceMinuteMeetingMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(ServiceMinuteMeeting record) {
        return serviceMinuteMeetingMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult<ServiceMinuteMeetingDTO> getMinuteMeetingList(ServiceMinuteMeetingQueryDTO record) {
        //  判断参数是否有误
        if(record.getCurrentPage() <= 0){
            record.setCurrentPage(1);  //设置默认当前页
        }
        if(record.getPageSize() <= 0) {
            record.setPageSize(5); // 默认每页5条
        }

        PageHelper.startPage(record.getCurrentPage(),record.getPageSize());
        List<ServiceMinuteMeetingDTO> lists = serviceMinuteMeetingMapper.getMinuteMeetingList(record);

        // 获取分页查询后的3 1
        PageInfo<ServiceMinuteMeetingDTO> pageInfo = new PageInfo<>(lists);
        // 封装需要返回的分页实体
        PageResult<ServiceMinuteMeetingDTO> result = new PageResult<ServiceMinuteMeetingDTO>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(lists);

        return result;
    }

    @Override
    public ServiceMinuteMeetingDTO getMinuteMeetingByTheeOneId(String meetingId) {
        return serviceMinuteMeetingMapper.getMinuteMeetingByTheeOneId(meetingId);
    }

    @Override
    public String getParticipateName(String meetingId) {
        return serviceMinuteMeetingMapper.getParticipateName(meetingId);
    }

}
