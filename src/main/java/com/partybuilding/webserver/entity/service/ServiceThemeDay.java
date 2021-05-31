package com.partybuilding.webserver.entity.service;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ServiceThemeDay {
    private String id;

    private String organizationId;

    private String editorId;

    private String status;

    private String title;

    private String partyMembersNumber;

    private String branchSecretaryId;

    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS",timezone = "GMT+8")
    private Date learningTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS",timezone = "GMT+8")
    private Date releaseTime;

    private String learningPlace;

    private String learningContent;

    private String learningWay;

    private String month;

    private String participantsId;

    private String overallEffect;

    private String likesNumber;

    private String viewsNumber;

    private String top;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId == null ? null : organizationId.trim();
    }

    public String getEditorId() {
        return editorId;
    }

    public void setEditorId(String editorId) {
        this.editorId = editorId == null ? null : editorId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPartyMembersNumber() {
        return partyMembersNumber;
    }

    public void setPartyMembersNumber(String partyMembersNumber) {
        this.partyMembersNumber = partyMembersNumber == null ? null : partyMembersNumber.trim();
    }

    public String getBranchSecretaryId() {
        return branchSecretaryId;
    }

    public void setBranchSecretaryId(String branchSecretaryId) {
        this.branchSecretaryId = branchSecretaryId == null ? null : branchSecretaryId.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getLearningTime() {
        return learningTime;
    }

    public void setLearningTime(Date learningTime) {
        this.learningTime = learningTime;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getLearningPlace() {
        return learningPlace;
    }

    public void setLearningPlace(String learningPlace) {
        this.learningPlace = learningPlace == null ? null : learningPlace.trim();
    }

    public String getLearningContent() {
        return learningContent;
    }

    public void setLearningContent(String learningContent) {
        this.learningContent = learningContent == null ? null : learningContent.trim();
    }

    public String getLearningWay() {
        return learningWay;
    }

    public void setLearningWay(String learningWay) {
        this.learningWay = learningWay == null ? null : learningWay.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public String getParticipantsId() {
        return participantsId;
    }

    public void setParticipantsId(String participantsId) {
        this.participantsId = participantsId == null ? null : participantsId.trim();
    }

    public String getOverallEffect() {
        return overallEffect;
    }

    public void setOverallEffect(String overallEffect) {
        this.overallEffect = overallEffect == null ? null : overallEffect.trim();
    }

    public String getLikesNumber() {
        return likesNumber;
    }

    public void setLikesNumber(String likesNumber) {
        this.likesNumber = likesNumber == null ? null : likesNumber.trim();
    }

    public String getViewsNumber() {
        return viewsNumber;
    }

    public void setViewsNumber(String viewsNumber) {
        this.viewsNumber = viewsNumber == null ? null : viewsNumber.trim();
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top == null ? null : top.trim();
    }
}