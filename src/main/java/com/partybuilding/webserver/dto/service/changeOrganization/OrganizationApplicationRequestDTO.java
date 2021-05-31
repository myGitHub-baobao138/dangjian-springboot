package com.partybuilding.webserver.dto.service.changeOrganization;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// 转组织关系创建dto
public class OrganizationApplicationRequestDTO {
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String id; // 转组织申请id
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String approvalHistoryId; // 审批历史id
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String approvalDate; // 审批时间

    private String userNumber; // 学号/工号

    private String userName; // 姓名

    private String userSex; // 性别

    private String originOrganizationName; // 原党支部名称

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private String originOrganizationId; // 原党支部 id

    private String targetOrganizationName; // 目的党支部名称

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private String targetOrganizationId; // 目的党支部 id

    private String userNation; // 民族

    @DateTimeFormat(pattern = "YYYY-MM-DD hh:mm:ss")
    private Date applicationDate; // 申请时间

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date birthday; // 出生年月

    private String reason; // 转组织原因

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserNation() {
        return userNation;
    }

    public void setUserNation(String userNation) {
        this.userNation = userNation;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getOriginOrganizationId() {
        return originOrganizationId;
    }

    public void setOriginOrganizationId(String originOrganizationId) {
        this.originOrganizationId = originOrganizationId;
    }

    public String getTargetOrganizationId() {
        return targetOrganizationId;
    }

    public void setTargetOrganizationId(String targetOrganizationId) {
        this.targetOrganizationId = targetOrganizationId;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApprovalHistoryId() {
        return approvalHistoryId;
    }

    public void setApprovalHistoryId(String approvalHistoryId) {
        this.approvalHistoryId = approvalHistoryId;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }
}
