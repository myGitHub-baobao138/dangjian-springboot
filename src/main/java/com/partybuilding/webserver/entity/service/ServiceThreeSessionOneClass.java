package com.partybuilding.webserver.entity.service;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 三会一课表
 */
public class ServiceThreeSessionOneClass {
    private String id;

    private String title;

    private String createdUserId;

    private String hostParticipate;

    private String meetingForm;

    private String meetingCategory;

    private String organizationId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS",timezone = "GMT+8")
    private Date meetingTime;

    private String meetingDuration;

    private String meetingStatus;

    private String meetingLevel;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS",timezone = "GMT+8")
    private Date releaseTime;

    private String meetingEditorId;

    private String minutesMeetingId;

    private String mainContent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCreateUserId() {
        return createdUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createdUserId = createUserId;
    }

    public String getHostParticipate() {
        return hostParticipate;
    }

    public void setHostParticipate(String hostParticipate) {
        this.hostParticipate = hostParticipate == null ? null : hostParticipate.trim();
    }

    public String getMeetingForm() {
        return meetingForm;
    }

    public void setMeetingForm(String meetingForm) {
        this.meetingForm = meetingForm == null ? null : meetingForm.trim();
    }

    public String getMeetingCategory() {
        return meetingCategory;
    }

    public void setMeetingCategory(String meetingCategory) {
        this.meetingCategory = meetingCategory == null ? null : meetingCategory.trim();
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public Date getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(Date meetingTime) {
        this.meetingTime = meetingTime;
    }

    public String getMeetingDuration() {
        return meetingDuration;
    }

    public void setMeetingDuration(String meetingDuration) {
        this.meetingDuration = meetingDuration == null ? null : meetingDuration.trim();
    }

    public String getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(String meetingStatus) {
        this.meetingStatus = meetingStatus == null ? null : meetingStatus.trim();
    }

    public String getMeetingLevel() {
        return meetingLevel;
    }

    public void setMeetingLevel(String meetingLevel) {
        this.meetingLevel = meetingLevel == null ? null : meetingLevel.trim();
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getMeetingEditorId() {
        return meetingEditorId;
    }

    public void setMeetingEditorId(String meetingEditorId) {
        this.meetingEditorId = meetingEditorId == null ? null : meetingEditorId.trim();
    }

    public String getMinutesMeetingId() {
        return minutesMeetingId;
    }

    public void setMinutesMeetingId(String minutesMeetingId) {
        this.minutesMeetingId = minutesMeetingId == null ? null : minutesMeetingId.trim();
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent == null ? null : mainContent.trim();
    }
}