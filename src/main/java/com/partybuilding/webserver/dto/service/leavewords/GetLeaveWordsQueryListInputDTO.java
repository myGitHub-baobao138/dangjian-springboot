package com.partybuilding.webserver.dto.service.leavewords;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * @Description: 按条件查找留言输入数据
 */
public class GetLeaveWordsQueryListInputDTO {

    /**
     * 管理员组织id
     */
    @NotEmpty(message = "管理员组织id不能为空")
    @NotNull(message = "管理员组织id不能为空")
    private String adminOrganizationId;

    /**
     * 选择的条件 ——> 组织id
     */
    private String selectOrganizationId;

    /**
     * 留言时间
     */
    private String leaveWordsTime;

    /**
     * 留言内容
     */
    private String leaveWordsContent;



    /**
     * 当前页数
     */
    @NotNull(message = "当前页数不能为空")
    private Integer currentPage;

    /**
     * 每页条数
     */
    @NotNull(message = "每页条数不能为空")
    private Integer pageSize;


    public String getAdminOrganizationId() {
        return adminOrganizationId;
    }

    public void setAdminOrganizationId(String adminOrganizationId) {
        this.adminOrganizationId = adminOrganizationId;
    }

    public String getSelectOrganizationId() {
        return selectOrganizationId;
    }

    public void setSelectOrganizationId(String selectOrganizationId) {
        this.selectOrganizationId = selectOrganizationId;
    }

    public String getLeaveWordsTime() {
        return leaveWordsTime;
    }

    public void setLeaveWordsTime(String leaveWordsTime) {
        this.leaveWordsTime = leaveWordsTime;
    }

    public String getLeaveWordsContent() {
        return leaveWordsContent;
    }

    public void setLeaveWordsContent(String leaveWordsContent) {
        this.leaveWordsContent = leaveWordsContent;
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

}
