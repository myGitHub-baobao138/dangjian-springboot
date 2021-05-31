package com.partybuilding.webserver.serviceImpl.system;

import com.partybuilding.webserver.dao.system.SysPartyReminderMapper;
import com.partybuilding.webserver.dao.system.SysPartyReminderTimeMapper;
import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.system.partyReminder.AddReminderDto;
import com.partybuilding.webserver.dto.system.partyReminder.AddReminderTimeDto;
import com.partybuilding.webserver.entity.system.SysPartyReminder;
import com.partybuilding.webserver.service.system.SysPartyReminderService;
import com.partybuilding.webserver.util.Uuid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * @description
 */
@Transactional
@Service
public class SysPartyReminderServiceImpl implements SysPartyReminderService {
    @Autowired
    SysPartyReminderTimeMapper timeMapper;

    @Autowired
    SysPartyReminderMapper mapper;

    @Autowired
    ModelMapper modelMapper;

    /**
     * 批量添加查询
     * @param list
     * @return
     */
    @Override
    public JsonResult insertList(List<AddReminderDto> list) {
        List<AddReminderTimeDto> addReminderTimeDtoList = new LinkedList<>();
        for (AddReminderDto addReminderDto:list){
            addReminderDto.setReminderId(Uuid.getUuid());
//            List<AddReminderTimeDto> addReminderTimeDtos = modelMapper.map(addReminderDto.getList(),new TypeToken<List<AddReminderTimeDto>>(){}.getType());
            List<AddReminderTimeDto> addReminderTimeDtos = addReminderDto.getList();
            for (AddReminderTimeDto addReminderTime1:addReminderTimeDtos){
                addReminderTime1.setReminderId(addReminderDto.getReminderId());
                addReminderTime1.setReminderTimeId(Uuid.getUuid());
            }
            addReminderTimeDtoList.addAll(addReminderTimeDtos);
            addReminderDto.setList(null);
        }
        JsonResult jsonResult = new JsonResult();
        int success = mapper.insertList(list);
        int timeSuccess= timeMapper.insertList(addReminderTimeDtoList);

        if (timeSuccess>0&&success>0){
            jsonResult.setMessage("添加成功");
            jsonResult.setCode(200);
        }else {
            jsonResult.setMessage("添加失败");
            jsonResult.setCode(500);
        }
        return jsonResult;
    }

}
