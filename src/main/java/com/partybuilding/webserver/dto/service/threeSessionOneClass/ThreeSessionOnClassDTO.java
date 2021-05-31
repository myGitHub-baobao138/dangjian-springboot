package com.partybuilding.webserver.dto.service.threeSessionOneClass;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class ThreeSessionOnClassDTO {

    /**
     * @Description 要返回的三会一课列表内容
     */

    private String id;

    private String title;

    private String meetingCategory;

    private String organizationId;

    private String organizationName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS",timezone = "GMT+8")
    private String releaseTime;

    private String meetingEditorName;//editor name

    private String meetingEditorId;

    private String meetingStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS",timezone = "GMT+8")
    private String meetingTime;

    private String minutesMeetingId;

    private String createdUserId;

    private String createdUserName;

    private String hostParticipate;

    private String hostParticipateName;

    private String meetingForm;

    private String meetingDuration;

    private String meetingLevel;

    private String mainContent;

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

    public String getMeetingCategory() {
        return meetingCategory;
    }

    public void setMeetingCategory(String meetingCategory) {
        this.meetingCategory = meetingCategory;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getMeetingEditorName() {
        return meetingEditorName;
    }

    public void setMeetingEditorName(String meetingEditorName) {
        this.meetingEditorName = meetingEditorName;
    }

    public String getMeetingEditorId() {
        return meetingEditorId;
    }

    public void setMeetingEditorId(String meetingEditorId) {
        this.meetingEditorId = meetingEditorId;
    }

    public String getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(String meetingStatus) {
        this.meetingStatus = meetingStatus;
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime;
    }

    public String getMinutesMeetingId() {
        return minutesMeetingId;
    }

    public void setMinutesMeetingId(String minutesMeetingId) {
        this.minutesMeetingId = minutesMeetingId;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

    public String getCreatedUserName() {
        return createdUserName;
    }

    public void setCreatedUserName(String createdUserName) {
        this.createdUserName = createdUserName;
    }

    public String getHostParticipate() {
        return hostParticipate;
    }

    public void setHostParticipate(String hostParticipate) {
        this.hostParticipate = hostParticipate;
    }

    public String getHostParticipateName() {
        return hostParticipateName;
    }

    public void setHostParticipateName(String hostParticipateName) {
        this.hostParticipateName = hostParticipateName;
    }

    public String getMeetingForm() {
        return meetingForm;
    }

    public void setMeetingForm(String meetingForm) {
        this.meetingForm = meetingForm;
    }

    public String getMeetingDuration() {
        return meetingDuration;
    }

    public void setMeetingDuration(String meetingDuration) {
        this.meetingDuration = meetingDuration;
    }

    public String getMeetingLevel() {
        return meetingLevel;
    }

    public void setMeetingLevel(String meetingLevel) {
        this.meetingLevel = meetingLevel;
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }
}
