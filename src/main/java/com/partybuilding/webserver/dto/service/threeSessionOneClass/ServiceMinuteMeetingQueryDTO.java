package com.partybuilding.webserver.dto.service.threeSessionOneClass;

import javax.validation.constraints.NotNull;

public class ServiceMinuteMeetingQueryDTO {
    /**
     * @Description 得到会议记录时需要的条件
     */

    /**
     * 按会议类型搜索
     */
    private String minuteType;

    /**
     * 记录时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT")
    private String recorderTime;

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

    public String getMinuteType() {
        return minuteType;
    }

    public void setMinuteType(String minuteType) {
        this.minuteType = minuteType;
    }

    public String getRecorderTime() {
        return recorderTime;
    }

    public void setRecorderTime(String recorderTime) {
        this.recorderTime = recorderTime;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
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
