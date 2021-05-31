package com.partybuilding.webserver.entity.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ServiceChangeOrganizationApproval {
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String id; // 审批记录 id
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String approvalDate; // 审批日期
    @NotEmpty(message = "审批人id不能为空")
    private String approverId; // 审批人 id
    @NotNull(message = "审批状态不能为空")
    private Integer state; // 审批状态
    private String remark; // 审批说明
    @NotEmpty(message = "转组织申请id为空")
    private String applicationId; // 转组织申请 id
    @NotEmpty(message = "当前审批人组织不能为空")
    private String currentApproverOrganizationId; // 当前审批人组织
    @NotEmpty(message = "原党支部id不能为空")
    private String originOrganizationId; // 原党支部id
    @NotEmpty(message = "移交党支部id不能为空")
    private String targetOrganizationId; // 移交党支部id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getApproverId() {
        return approverId;
    }

    public void setApproverId(String approverId) {
        this.approverId = approverId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getCurrentApproverOrganizationId() {
        return currentApproverOrganizationId;
    }

    public void setCurrentApproverOrganizationId(String currentApproverOrganization) {
        this.currentApproverOrganizationId = currentApproverOrganization;
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
}
