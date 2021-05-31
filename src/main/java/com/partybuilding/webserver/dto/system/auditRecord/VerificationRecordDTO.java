package com.partybuilding.webserver.dto.system.auditRecord;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public class VerificationRecordDTO {
    /**
     * 审核记录id
     */
    private String id;

    /**
     * 审核时间
     */
    private String auditTime;

    /**
     * 审核结果 0-成功 1-失败
     */
    private Integer auditResult;

    /**
     * 审核人
     */
    private String auditUser;

    /**
     * 备注
     */
    private String remarks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(Integer auditResult) {
        this.auditResult = auditResult;
    }

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

