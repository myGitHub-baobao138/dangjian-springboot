package com.partybuilding.webserver.dto.service.changeOrganization;

public class OrganizationApprovalHistory {
    private String approvalDate; // 审批日期
    private String approverName; // 审批人名称
    private String state; // 状态
    private String remark; // 备注

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
