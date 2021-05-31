package com.partybuilding.webserver.dto.system.right;

import javax.validation.constraints.NotNull;

/**
 * 查找权限管理基本信息请求对象
 */
public class FindRightBaseInfoPageInfo {
    private String organizationId; // 组织id
    private String organizationName; // 组织名称
    private String postId; // 职务id
    private String postName; // 职务名称
    private String organizationRank;// 组织等级

    public String getOrganizationRank() {
        return organizationRank;
    }

    public void setOrganizationRank(String organizationRank) {
        this.organizationRank = organizationRank;
    }

    // 当前页
    @NotNull(message = "当前页数不能为空")
    private Integer currentPage;


    // 每页数量
    @NotNull(message = "每页数量不能为空")
    private Integer pageSize;

    public FindRightBaseInfoPageInfo() {
        this.organizationName = "";
        this.postName = "";
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
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
