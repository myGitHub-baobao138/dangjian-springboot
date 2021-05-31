package com.partybuilding.webserver.service.service;

import com.partybuilding.webserver.dto.service.threeSessionOneClass.ServiceMinuteMeetingDTO;
import com.partybuilding.webserver.dto.service.threeSessionOneClass.ServiceMinuteMeetingQueryDTO;
import com.partybuilding.webserver.entity.service.ServiceMinuteMeeting;
import com.partybuilding.webserver.util.PageResult;

import java.util.List;

public interface ServiceMinuteMeetingService {

    int insert(ServiceMinuteMeeting record);

    int insertSelective(ServiceMinuteMeeting record);

    int updateByPrimaryKey(ServiceMinuteMeeting record);

    PageResult<ServiceMinuteMeetingDTO> getMinuteMeetingList(ServiceMinuteMeetingQueryDTO record);

    ServiceMinuteMeetingDTO getMinuteMeetingByTheeOneId(String meetingId);

    String getParticipateName(String meetingId);

}
