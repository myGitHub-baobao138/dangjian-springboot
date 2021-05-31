package com.partybuilding.webserver.entity.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 志愿活动表
 */
public class ServiceVolunteerActivity {
    private String id;

    private String organizationId;

    private String activityTitle;

    private String activityContent;

    private String activityContact;

    private String contactNumber;

    private String activityLocation;

    private String meetingPlace;

    private Date registrationDeadline;

    private Date activityTime;

    private String picture;

    private String annex;

    private String activitySponsorId;

    private String activityState;

    private Integer signUpNumber;

    private Date releaseTime;

    private Integer readingVolume;

    private String activitySource;

    private Date submissionTime;

    private String approvalState;

    private String reviewerId;

    private Date reviewTime;

    private Integer likeNumber;

    private String reviewDescription;

    private String activitySponsorIdentity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
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

    public Integer getSignUpNumber() {
        return signUpNumber;
    }

    public void setSignUpNumber(Integer signUpNumber) {
        this.signUpNumber = signUpNumber;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getReadingVolume() {
        return readingVolume;
    }

    public void setReadingVolume(Integer readingVolume) {
        this.readingVolume = readingVolume;
    }

    public String getActivitySource() {
        return activitySource;
    }

    public void setActivitySource(String activitySource) {
        this.activitySource = activitySource;
    }

    public Date getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getApprovalState() {
        return approvalState;
    }

    public void setApprovalState(String approvalState) {
        this.approvalState = approvalState;
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public String getActivitySponsorIdentity() {
        return activitySponsorIdentity;
    }

    public void setActivitySponsorIdentity(String activitySponsorIdentity) {
        this.activitySponsorIdentity = activitySponsorIdentity;
    }
}