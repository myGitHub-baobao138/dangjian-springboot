package com.partybuilding.webserver.dto.service.volunteer;

import java.util.Date;

/**
 * author 包嵩&zy
 * 添加活动信息的类
 */
public class InsertActivityDTO {

    /**
     * 随机生成活动id
     */
    private String uuid;

    /**
     * 活动状态 1-未发布 2-报名中  3-报名截止 4-活动结束
     */
    private String activityState;

    /**
     * 活动标题
     */
    private String activityTitle;

    /**
     * 活动内容
     */
    private String activityContent;

    /**
     * 活动联系人
     */
    private String activityContact;

    /**
     * 活动联系方式
     */
    private String contactNumber;

    /**
     * 活动地点
     */
    private String activityLocation;

    /**
     * 集合地点
     */
    private String meetingPlace;

    /**
     * 活动时间
     */
    private Date activityTime;

    /**
     * 活动截止时间
     */
    private Date activityDeadline;

    /**
     * 活动图片
     */
    private String picture;

    /**
     * 活动附件
     */
    private String annex;

    /**
     * 发起人活动id
     */
    private String activitySponsorId;

    /**
     * 活动来源
     */
    private String activitySource;

    /**
     * 发布时间
     */
    private Date releaseTime;

    /**
     * 投稿时间
     */
    private Date submissionTime;

    /**
     * 组织id
     */
    private String organizationId;

    /**
     * 活动发起人id
     */
    private String activitySponsorIdentity;

    /**
     * 审核状态
     */
    private String approvalState;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getActivityState() {
        return activityState;
    }

    public void setActivityState(String activityState) {
        this.activityState = activityState;
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

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public Date getActivityDeadline() {
        return activityDeadline;
    }

    public void setActivityDeadline(Date activityDeadline) {
        this.activityDeadline = activityDeadline;
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

    public String getActivitySponsorId() {
        return activitySponsorId;
    }

    public void setActivitySponsorId(String activitySponsorId) {
        this.activitySponsorId = activitySponsorId;
    }

    public String getActivitySource() {
        return activitySource;
    }

    public void setActivitySource(String activitySource) {
        this.activitySource = activitySource;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getActivitySponsorIdentity() {
        return activitySponsorIdentity;
    }

    public void setActivitySponsorIdentity(String activitySponsorIdentity) {
        this.activitySponsorIdentity = activitySponsorIdentity;
    }

    public String getApprovalState() {
        return approvalState;
    }

    public void setApprovalState(String approvalState) {
        this.approvalState = approvalState;
    }
}
