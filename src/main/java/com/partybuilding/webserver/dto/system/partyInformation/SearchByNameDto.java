package com.partybuilding.webserver.dto.system.partyInformation;

import javax.validation.constraints.NotNull;

public class SearchByNameDto {
    /**
     * 党员姓名
     */
    private String name;
    /**
     * 账号
     */
    @NotNull(message = "账号不能为空")
    private String userId;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return userId;
    }

    public void setAccount(String account) {
        this.userId = account;
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
