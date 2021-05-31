package com.partybuilding.webserver.dto.service.volunteer;



import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * 添加志愿活动
 */
public class ServiceAddVolunteerActivityDTO {
    /**
     * 1.志愿活动id
     */
    private String id;

    /**
     * 2.活动标题
     */
    private String activityTitle;

    /**
     * 3.活动联系人
     */
    private String activityContact;

    /**
     * 4.联系电话
     */
    private String contactNumber;

    /**
     * 5.活动地点
     */
    private String activityLocation;

    /**
     * 6.集合地点
     */
    private String meetingPlace;

    /**
     * 7.活动时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date activityTime;

    /**
     * 8.图片
     */
    private String picture;

    /**
     * 9.附件
     */
    private String annex;

    /**
     * 10.活动发起人id
     */
    private String activitySponsorId;

    /**
     * 11.活动状态
     */
    private String activityState;

    /**
     * 12.发布时间
     */
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date releaseTime;

    /**
     * 13.活动来源
     */
    private String activitySource;

    /**
     * 14.活动内容
     */
    private String activityContent;

    /**
     * 15.报名截止时间
     */
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date registrationDeadline;

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

    public String getActivityState() {
        return activityState;
    }

    public void setActivityState(String activityState) {
        this.activityState = activityState;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getActivitySource() {
        return activitySource;
    }

    public void setActivitySource(String activitySource) {
        this.activitySource = activitySource;
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    public Date getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(Date registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }
}
