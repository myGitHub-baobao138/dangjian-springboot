package com.partybuilding.webserver.dto.service.volunteer;

/**
 * author 包嵩
 * 审核通过和未通过
 */
public class ExamineDTO {
    /**
     * 审核活动的id
     */
    private String[] id;

    /**
     * 审核的状态
     */
    private String approvalState;


    public String[] getId() {
        return id;
    }

    public void setId(String[] id) {
        this.id = id;
    }

    public String getApprovalState() {
        return approvalState;
    }

    public void setApprovalState(String approvalState) {
        this.approvalState = approvalState;
    }
}
