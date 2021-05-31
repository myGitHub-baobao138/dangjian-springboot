package com.partybuilding.webserver.dto.service.changeOrganization;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FindChangeOrganizationInfoPageDTO {
    @NotEmpty(message = "当前组织id不能为空")
    private String currentOrganizationId; // 当前组织 id
    @NotEmpty(message = "当前组织等级不能为空")
    private String currentOrganizationRank; // 当前组织等级
    private String name; // 搜索填入的用户名称
    private String applicationDate; // 搜索填入的时间
    private Integer progress; // 搜索填入的申请进度
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


    public FindChangeOrganizationInfoPageDTO() {
        this.name = "";
    }

    public String getCurrentOrganizationId() {
        return currentOrganizationId;
    }

    public void setCurrentOrganizationId(String currentOrganizationId) {
        this.currentOrganizationId = currentOrganizationId;
    }

    public String getCurrentOrganizationRank() {
        return currentOrganizationRank;
    }

    public void setCurrentOrganizationRank(String currentOrganizationRank) {
        this.currentOrganizationRank = currentOrganizationRank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
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
