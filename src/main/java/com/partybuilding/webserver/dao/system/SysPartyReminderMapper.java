package com.partybuilding.webserver.dao.system;

import com.partybuilding.webserver.dto.system.partyReminder.AddReminderDto;
import com.partybuilding.webserver.dto.system.partyReminder.AddReminderTimeDto;
import com.partybuilding.webserver.entity.system.SysPartyReminder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description
 */
@Mapper
@Repository
public interface SysPartyReminderMapper {
    int insertList(@Param("list") List<AddReminderDto> sysPartyReminders);
}
