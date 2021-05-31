package com.partybuilding.webserver.dto.system.academy;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 获取学院列表的输入dto
 */

public class GetAcademyListInputDTO {
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
