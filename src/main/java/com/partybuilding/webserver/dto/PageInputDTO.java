package com.partybuilding.webserver.dto;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 分页输入 基础数据类
 */
public class PageInputDTO {
    /**
     * 账号
     */
    @NotNull(message = "党员id不能为空")
    private String partyId;

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
}
