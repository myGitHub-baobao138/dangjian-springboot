package com.partybuilding.webserver.dto.system.auditRecord;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public class VerifyWxUserInputListDTO {

    /**
     * 微信用户id
     */
    @NotNull(message = "微信用户id不能为空")
    @NotEmpty(message = "不能为空串")
    private List<String> wxUserIds;

    /**
     * 认证结果 1-成功 2-失败
     */
    @NotNull(message = "审核结果不能为空")
    private Integer auditResult;

    /**
     * 认证时间 精确到时分秒
     */
    @NotNull(message = "审核时间不能为空")
    @NotEmpty(message = "审核时间不能为空串")
    private String verifyTime;

    /**
     * 备注说明
     */
    private String remarks;

    /**
     * 管理员的党员id(回复人id)
     */
    @NotNull(message = "管理员的党员id不能为空")
    @NotEmpty(message = "管理员的党员id不能为空串")
    private String partyId;



    // 微信用户组织职务id
    @NotNull(message = "管理员的组织职务id不能为空")
    @NotEmpty(message = "不能为空串")
    private List<String> organPostIds;



    public List<String> getWxUserIds() {
        return wxUserIds;
    }

    public void setWxUserIds(List<String> wxUserIds) {
        this.wxUserIds = wxUserIds;
    }



    public String getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(String verifyTime) {
        this.verifyTime = verifyTime;
    }

    public Integer getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(Integer auditResult) {
        this.auditResult = auditResult;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public List<String> getOrganPostIds() {
        return organPostIds;
    }

    public void setOrganPostIds(List<String> organPostIds) {
        this.organPostIds = organPostIds;
    }
}
