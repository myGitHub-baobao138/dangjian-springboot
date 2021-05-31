package com.partybuilding.webserver.dto.system.partyReminder;


import java.util.List;

/**
 * @description
 */

public class AddReminderDto {

    private String reminderId;
    private String meetingName;
    private String partyId;
    private List<AddReminderTimeDto> list;

    public String getReminderId() {
        return reminderId;
    }

    public void setReminderId(String reminderId) {
        this.reminderId = reminderId;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public List<AddReminderTimeDto> getList() {
        return list;
    }

    public void setList(List<AddReminderTimeDto> list) {
        this.list = list;
    }
}
