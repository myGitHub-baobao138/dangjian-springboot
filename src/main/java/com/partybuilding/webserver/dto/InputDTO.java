package com.partybuilding.webserver.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public class InputDTO {
    /**
     * 当前页
     */
    @NotNull(message = "当前页数不能为空")
    @NotEmpty(message = "当前页数不能为空串")
    private Integer currentPage;

    /**
     * 每页数量
     */
    @NotNull(message = "每页数量不能为空")
    @NotEmpty(message = "每页数量不能为空串")
    private Integer pageSize;

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
