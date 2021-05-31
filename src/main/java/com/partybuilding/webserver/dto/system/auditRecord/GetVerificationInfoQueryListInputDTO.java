package com.partybuilding.webserver.dto.system.auditRecord;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public class GetVerificationInfoQueryListInputDTO {

    /**
     * 管理员组织id
     */

    @NotEmpty(message = "管理员组织id不能为空")
    @NotNull(message = "管理员组织id不能为空")
    private String adminOrganizationId;

    /**
     * 选择的条件 ——> 组织id
     */
    private String wxOrganizationId;

    /**
     * 当前页
     */
    @NotNull(message = "当前页数不能为空")
    private Integer currentPage;

    /**
     * 每页数量
     */
    @NotNull(message = "每页数量不能为空")
    private Integer pageSize;


    /**
     * 姓名
     */
    private String name;

    /**
     * 认证状态 0-未 1-成功 2-失败
     */
    private Integer isAudited;


    /**
     * 类别 0-学生 1-教师
     */
    private Integer type;

    /**
     * 是否书记 0-党员 1-书记
     */
    private Integer isSecretary;

    public String getAdminOrganizationId() {
        return adminOrganizationId;
    }

    public void setAdminOrganizationId(String adminOrganizationId) {
        this.adminOrganizationId = adminOrganizationId;
    }

    public String getWxOrganizationId() {
        return wxOrganizationId;
    }

    public void setWxOrganizationId(String wxOrganizationId) {
        this.wxOrganizationId = wxOrganizationId;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsAudited() {
        return isAudited;
    }

    public void setIsAudited(Integer isAudited) {
        this.isAudited = isAudited;
    }



    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsSecretary() {
        return isSecretary;
    }

    public void setIsSecretary(Integer isSecretary) {
        this.isSecretary = isSecretary;
    }

}
