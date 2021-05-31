package com.partybuilding.webserver.dto.system.partyInformation;

import javax.validation.constraints.NotNull;

/**
 * 查看党员基本信息对象
 */
public class FindPartyBaseInfoPageInfoDTO {
    // 当前页
    @NotNull(message = "当前页数不能为空")
    private Integer currentPage;

    // 每页数量
    @NotNull(message = "每页数量不能为空")
    private Integer pageSize;
    private String partyName; // 党员姓名
    private String postName; // 职务名称
    private String rank; // 当前组织等级
    private String currentUserOrganizationId; // 当前操作人党员id

    public FindPartyBaseInfoPageInfoDTO() {
        this.partyName = "";
        this.postName = "";
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

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getCurrentUserOrganizationId() {
        return currentUserOrganizationId;
    }

    public void setCurrentUserOrganizationId(String currentUserOrganizationId) {
        this.currentUserOrganizationId = currentUserOrganizationId;
    }
}
