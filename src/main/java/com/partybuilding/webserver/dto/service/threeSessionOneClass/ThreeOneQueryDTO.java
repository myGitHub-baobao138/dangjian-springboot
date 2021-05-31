package com.partybuilding.webserver.dto.service.threeSessionOneClass;

import javax.validation.constraints.NotNull;

public class ThreeOneQueryDTO {
    /**
     * @Description 根据 条件 得到三会一课列表
     */

    /**
     * 按标题搜索
     */
    private String title;

    /**
     * 发布时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT")
    private String releaseTime;

    /**
     * 会议类型
     */
    private String meetingCategory;

    /**
     * 管理员账号
     */
//    @NotNull(message = "管理员党员id不能为空")
    private String partyId;

    /**
     * 管理员所在组织
     */
    @NotNull(message = "所在组织不能为空")
    private String organizationId;

    @NotNull(message = "所属级别不能为空")
    private String rank;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getMeetingCategory() {
        return meetingCategory;
    }

    public void setMeetingCategory(String meetingCategory) {
        this.meetingCategory = meetingCategory;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
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

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
