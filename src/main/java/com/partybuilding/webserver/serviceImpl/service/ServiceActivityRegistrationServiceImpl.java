package com.partybuilding.webserver.serviceImpl.service;

import com.partybuilding.webserver.dao.service.ServiceActivityRegistrationMapper;
import com.partybuilding.webserver.dto.service.volunteer.InsertActivityDTO;
import com.partybuilding.webserver.dto.service.volunteer.SelectRegistrationDetailsDTO;
import com.partybuilding.webserver.entity.service.ServiceActivityRegistration;
import com.partybuilding.webserver.service.service.ServiceActivityRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceActivityRegistrationServiceImpl implements ServiceActivityRegistrationService {

    @Autowired(required = false)
    ServiceActivityRegistrationMapper mapper;


    @Override
    public List<SelectRegistrationDetailsDTO> selectInfoByActivityId(String activityId) {
        return mapper.selectInfoByActivityId(activityId);
    }

    @Override
    public int insertActivity(InsertActivityDTO dto) {
        return mapper.insertActivity(dto);
    }
}
