package com.partybuilding.webserver.dto.service.threeSessionOneClass;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ServiceMinuteMeetingDTO {

    private String id;

    private String title;

    private String minuteType;

    private String organizationName;

    private String hostParticipateId;

    private String hostParticipateName;

    private String meetingId;

    private String meetingRecorderId;

    private String meetingRecorderName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS",timezone = "GMT+8")
    private Date recorderTime;

    private String minuteContent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMinuteType() {
        return minuteType;
    }

    public void setMinuteType(String minuteType) {
        this.minuteType = minuteType;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getHostParticipateId() {
        return hostParticipateId;
    }

    public void setHostParticipateId(String hostParticipateId) {
        this.hostParticipateId = hostParticipateId;
    }

    public String getHostParticipateName() {
        return hostParticipateName;
    }

    public void setHostParticipateName(String hostParticipateName) {
        this.hostParticipateName = hostParticipateName;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public String getMeetingRecorderId() {
        return meetingRecorderId;
    }

    public void setMeetingRecorderId(String meetingRecorderId) {
        this.meetingRecorderId = meetingRecorderId;
    }

    public String getMeetingRecorderName() {
        return meetingRecorderName;
    }

    public void setMeetingRecorderName(String meetingRecorderName) {
        this.meetingRecorderName = meetingRecorderName;
    }

    public Date getRecorderTime() {
        return recorderTime;
    }

    public void setRecorderTime(Date recorderTime) {
        this.recorderTime = recorderTime;
    }

    public String getMinuteContent() {
        return minuteContent;
    }

    public void setMinuteContent(String minuteContent) {
        this.minuteContent = minuteContent;
    }
}
