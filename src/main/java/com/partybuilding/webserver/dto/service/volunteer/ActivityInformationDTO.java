package com.partybuilding.webserver.dto.service.volunteer;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 查看活动详情
 */
public class ActivityInformationDTO {
    /**
     * 活动标题
     */
    private String title;
    /**
     * 活动内容
     */
    private String content;
    /**
     * 活动地点
     */
    private String activityLocation;
    /**
     * 集合地点
     */
    private String meetingPlace;
    /**
     * 组织人姓名
     */
    private String activityContact;
    /**
     * 联系方式
     */
    private String contactNumber;
    /**
     * 集合时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date activityTime;
    /**
     * 活动报名截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date registrationDeadline;
    /**
     * 图片
     */
    private String picture;
    /**
     * 附件
     */
    private String annex;
    /**
     * 发起人姓名
     */
    private String activitySponsorName;
    /**
     * 发起人身份
     */
    private String activitySponsorPost;
    /**
     * 投稿时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date submissionTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public Date getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(Date registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
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

    public String getActivitySponsorName() {
        return activitySponsorName;
    }

    public void setActivitySponsorName(String activitySponsorName) {
        this.activitySponsorName = activitySponsorName;
    }

    public String getActivitySponsorPost() {
        return activitySponsorPost;
    }

    public void setActivitySponsorPost(String activitySponsorPost) {
        this.activitySponsorPost = activitySponsorPost;
    }

    public Date getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
    }
}
