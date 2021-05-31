package com.partybuilding.webserver.entity.service;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ServiceChangeOrganization {
    private String id; // 转组织申请id

    private String userNumber; // 学号/工号

    private String userName; // 姓名

    private String userSex; // 性别

    private String orginOrganizationId; // 原党支部id

    private String originOrganizationName; // 原党支部名称

    private String targetOrganizationId; // 目的党支部id

    private String targetOrganizationName; // 现党支部名称

    private String userNation; // 民族

    private String changeReason; // 转组织原因

    private Integer state; // 审核状态 (0 原党支部未审核，1 现党支部未审核，2 审核失败，3 审核通过)

    private Integer progress; // 审核进度 (0 审批中，1 申请，2 完成)

    @JsonFormat(pattern = "yyyy/MM/dd")
    private String applicationDate; // 申请时间
    @JsonFormat(pattern = "yyyy/MM/dd")
    private String birthday; // 出生年月

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber == null ? null : userNumber.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getOrginOrganizationId() {
        return orginOrganizationId;
    }

    public void setOrginOrganizationId(String orginOrganizationId) {
        this.orginOrganizationId = orginOrganizationId == null ? null : orginOrganizationId.trim();
    }

    public String getTargetOrganizationId() {
        return targetOrganizationId;
    }

    public void setTargetOrganizationId(String targetOrganizationId) {
        this.targetOrganizationId = targetOrganizationId == null ? null : targetOrganizationId.trim();
    }

    public String getUserNation() {
        return userNation;
    }

    public void setUserNation(String userNation) {
        this.userNation = userNation == null ? null : userNation.trim();
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason == null ? null : changeReason.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getOriginOrganizationName() {
        return originOrganizationName;
    }

    public void setOriginOrganizationName(String originOrganizationName) {
        this.originOrganizationName = originOrganizationName;
    }

    public String getTargetOrganizationName() {
        return targetOrganizationName;
    }

    public void setTargetOrganizationName(String targetOrganizationName) {
        this.targetOrganizationName = targetOrganizationName;
    }
}