package com.partybuilding.webserver.dto.service.volunteer;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 保存活动报名页面的信息
 * author 包嵩
 */
public class ActivityRegistrationDTO {
    private String id;
    /**
     * 活动主题
     */
    private String activityTitle;

    /**
     * 活动内容
     */
    private String activityContent;

    /**
     * 活动发起人
     */
    private String activitySponsor;

    /**
     * 活动状态
     */
    private String activityState;

    /**
     * 活动报名人数
     */
    private int registrationNumber;


    /**
     * 活动发起人身份
     */
    private String activitySponsorIdentity;

    /**
     * 活动地点
     */
    private String activityLocation;

    /**
     * 集合地点
     */
    private String meetingPlace;


    /**
     * 活动联系人、组织人
     */
    private String activityContact;

    /**
     * 活动联系人、组织人联系方式
     */
    private String contactNumber;


    /**
     * 截止时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm",timezone = "GMT+8")
    private Date registrationDeadline;

    /**
     * 活动时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm",timezone = "GMT+8")
    private Date activityTime;

    /**
     * 活动图片
     */
    private String picture;

    /**
     * 活动附件
     */
    private String annex;

    /**
     * 投稿时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd" ,timezone = "GMT+8")
    private Date submissionTime;

    public Date getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    public String getActivitySponsor() {
        return activitySponsor;
    }

    public void setActivitySponsor(String activitySponsor) {
        this.activitySponsor = activitySponsor;
    }

    public String getActivityState() {
        return activityState;
    }

    public void setActivityState(String activityState) {
        this.activityState = activityState;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getActivitySponsorIdentity() {
        return activitySponsorIdentity;
    }

    public void setActivitySponsorIdentity(String activitySponsorIdentity) {
        this.activitySponsorIdentity = activitySponsorIdentity;
    }

    public String getActivityLocation() {
        return activityLocation;
    }

    public void setActivityLocation(String activityLocation) {
        this.activityLocation = activityLocation;
    }

    public String getMeetingPlace() {
        return meetingPlace;
    }

    public void setMeetingPlace(String meetingPlace) {
        this.meetingPlace = meetingPlace;
    }

    public String getActivityContact() {
        return activityContact;
    }

    public void setActivityContact(String activityContact) {
        this.activityContact = activityContact;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(Date registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAnnex() {
        return annex;
    }

    public void setAnnex(String annex) {
        this.annex = annex;
    }
}
