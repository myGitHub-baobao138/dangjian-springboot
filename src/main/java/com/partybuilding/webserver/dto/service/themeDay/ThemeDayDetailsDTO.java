package com.partybuilding.webserver.dto.service.themeDay;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ThemeDayDetailsDTO {

    private String id;

    private String organizationId;

    private String organizationName;

    private String editorId;

    private String editorName;

    private String status;

    private String title;

    private String partyMembersNumber;

    private String branchSecretaryId;

    private String branchSecretaryName;

    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS",timezone = "GMT+8")
    private Date learningTime;

    private Date releaseTime;

    private String learningPlace;

    private String learningContent;

    private String learningWay;

    private String month;

    private String participantsId;

    private String participantsName;

    private String overallEffect;

    private String likesNumber;

    private String viewsNumber;

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

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getEditorId() {
        return editorId;
    }

    public void setEditorId(String editorId) {
        this.editorId = editorId;
    }

    public String getEditorName() {
        return editorName;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPartyMembersNumber() {
        return partyMembersNumber;
    }

    public void setPartyMembersNumber(String partyMembersNumber) {
        this.partyMembersNumber = partyMembersNumber;
    }

    public String getBranchSecretaryId() {
        return branchSecretaryId;
    }

    public void setBranchSecretaryId(String branchSecretaryId) {
        this.branchSecretaryId = branchSecretaryId;
    }

    public String getBranchSecretaryName() {
        return branchSecretaryName;
    }

    public void setBranchSecretaryName(String branchSecretaryName) {
        this.branchSecretaryName = branchSecretaryName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        this.learningPlace = learningPlace;
    }

    public String getLearningContent() {
        return learningContent;
    }

    public void setLearningContent(String learningContent) {
        this.learningContent = learningContent;
    }

    public String getLearningWay() {
        return learningWay;
    }

    public void setLearningWay(String learningWay) {
        this.learningWay = learningWay;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getParticipantsId() {
        return participantsId;
    }

    public void setParticipantsId(String participantsId) {
        this.participantsId = participantsId;
    }

    public String getParticipantsName() {
        return participantsName;
    }

    public void setParticipantsName(String participantsName) {
        this.participantsName = participantsName;
    }

    public String getOverallEffect() {
        return overallEffect;
    }

    public void setOverallEffect(String overallEffect) {
        this.overallEffect = overallEffect;
    }

    public String getLikesNumber() {
        return likesNumber;
    }

    public void setLikesNumber(String likesNumber) {
        this.likesNumber = likesNumber;
    }

    public String getViewsNumber() {
        return viewsNumber;
    }

    public void setViewsNumber(String viewsNumber) {
        this.viewsNumber = viewsNumber;
    }
}
