package com.partybuilding.webserver.dao.service;

import com.partybuilding.webserver.dto.service.threeSessionOneClass.ServiceMinuteMeetingDTO;
import com.partybuilding.webserver.dto.service.threeSessionOneClass.ServiceMinuteMeetingQueryDTO;
import com.partybuilding.webserver.entity.service.ServiceMinuteMeeting;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServiceMinuteMeetingMapper {
    int deleteByPrimaryKey(String id);

    int insert(ServiceMinuteMeeting record);

    int insertSelective(ServiceMinuteMeeting record);

    ServiceMinuteMeeting selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ServiceMinuteMeeting record);

    int updateByPrimaryKeyWithBLOBs(ServiceMinuteMeeting record);

    int updateByPrimaryKey(ServiceMinuteMeeting record);

    List<ServiceMinuteMeetingDTO> getMinuteMeetingList(ServiceMinuteMeetingQueryDTO record);

    ServiceMinuteMeetingDTO getMinuteMeetingByTheeOneId(String meetingId);

    String getParticipateName(String meetingId);

}