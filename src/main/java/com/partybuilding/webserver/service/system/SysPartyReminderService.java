package com.partybuilding.webserver.service.system;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.system.partyReminder.AddReminderDto;
import com.partybuilding.webserver.dto.system.partyReminder.AddReminderTimeDto;

import java.util.List;

/**
 * @description
 */
public interface SysPartyReminderService {
    JsonResult insertList(List<AddReminderDto> list);
}
