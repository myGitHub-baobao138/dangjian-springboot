package com.partybuilding.webserver.entity.system;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @description
 */

public class SysPartyReminderTime {
    private String id;
    //提醒时间
    private String reminderTime;
    //提醒表的id
    private String reminderId;

    private Boolean isReminder;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(String reminderTime) {
        this.reminderTime = reminderTime;
    }

    public String getReminderId() {
        return reminderId;
    }

    public void setReminderId(String reminderId) {
        this.reminderId = reminderId;
    }

    public Boolean getReminder() {
        return isReminder;
    }

    public void setReminder(Boolean reminder) {
        isReminder = reminder;
    }
}
