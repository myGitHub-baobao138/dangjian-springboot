package com.partybuilding.webserver.dto.service.threeSessionOneClass;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.partybuilding.webserver.entity.service.ServiceParticipateThreeSessionOneClass;

import java.util.Date;
import java.util.List;

public class threeOnePartyDTO {

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

    List<ServiceParticipateThreeSessionOneClass> serviceParticipateThreeSessionOneClassList;

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

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

    public String getHostParticipate() {
        return hostParticipate;
    }

    public void setHostParticipate(String hostParticipate) {
        this.hostParticipate = hostParticipate;
    }

    public String getMeetingForm() {
        return meetingForm;
    }

    public void setMeetingForm(String meetingForm) {
        this.meetingForm = meetingForm;
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
        this.meetingDuration = meetingDuration;
    }

    public String getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(String meetingStatus) {
        this.meetingStatus = meetingStatus;
    }

    public String getMeetingLevel() {
        return meetingLevel;
    }

    public void setMeetingLevel(String meetingLevel) {
        this.meetingLevel = meetingLevel;
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
        this.meetingEditorId = meetingEditorId;
    }

    public String getMinutesMeetingId() {
        return minutesMeetingId;
    }

    public void setMinutesMeetingId(String minutesMeetingId) {
        this.minutesMeetingId = minutesMeetingId;
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }

    public List<ServiceParticipateThreeSessionOneClass> getServiceParticipateThreeSessionOneClassList() {
        return serviceParticipateThreeSessionOneClassList;
    }

    public void setServiceParticipateThreeSessionOneClassList(List<ServiceParticipateThreeSessionOneClass> serviceParticipateThreeSessionOneClassList) {
        this.serviceParticipateThreeSessionOneClassList = serviceParticipateThreeSessionOneClassList;
    }
}
