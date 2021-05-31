package com.partybuilding.webserver.dto.system.partyReminder;



/**
 * @description
 */

public class AddReminderTimeDto {
    //提醒时间表的id
    private String reminderTimeId;
    private String reminderId;
    private String time;

    private Boolean isReminder=false;

    public Boolean getReminder() {
        return isReminder;
    }

    public void setReminder(Boolean reminder) {
        isReminder = reminder;
    }

    public String getReminderId() {
        return reminderId;
    }

    public void setReminderId(String reminderId) {
        this.reminderId = reminderId;
    }

    public String getReminderTimeId() {
        return reminderTimeId;
    }

    public void setReminderTimeId(String reminderTimeId) {
        this.reminderTimeId = reminderTimeId;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
