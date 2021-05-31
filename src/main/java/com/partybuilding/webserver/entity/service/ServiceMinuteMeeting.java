package com.partybuilding.webserver.entity.service;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 会议纪要表
 */
public class ServiceMinuteMeeting {
    private String id;

    private String minuteType;

    private String meetingId;

    private String meetingRecorderId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS",timezone = "GMT+8")
    private Date recorderTime;

    private String minuteContent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMinuteType() {
        return minuteType;
    }

    public void setMinuteType(String minuteType) {
        this.minuteType = minuteType == null ? null : minuteType.trim();
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId == null ? null : meetingId.trim();
    }

    public String getMeetingRecorderId() {
        return meetingRecorderId;
    }

    public void setMeetingRecorderId(String meetingRecorderId) {
        this.meetingRecorderId = meetingRecorderId == null ? null : meetingRecorderId.trim();
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
        this.minuteContent = minuteContent == null ? null : minuteContent.trim();
    }
}