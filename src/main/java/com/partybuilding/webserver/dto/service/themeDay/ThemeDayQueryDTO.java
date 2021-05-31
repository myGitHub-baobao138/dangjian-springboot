package com.partybuilding.webserver.dto.service.themeDay;

import javax.validation.constraints.NotNull;

public class ThemeDayQueryDTO {
    /**
     * @Description 搜索表格内容的条件项
     */

    /**
     * 按组织名称搜索
     */
    private String organizationName;

    /**
     * 按发布时间搜索
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT")
    private String releaseTime;

    /**
     * 当前登陆者的党员id
     */
//    @NotNull(message = "党员id不能为空")
    private String partyId;

    /**
     * 管理员所在组织
     */
    @NotNull(message = "所在组织不能为空")
    private String organizationId;

    @NotNull(message = "所属级别不能为空")
    private String rank;

//    @NotNull(message = "职务不能为空")
    private String postId;

    @NotNull(message = "当前页数不能为空")
    private Integer currentPage;

    @NotNull(message = "每页条数不能为空")
    private Integer pageSize;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
