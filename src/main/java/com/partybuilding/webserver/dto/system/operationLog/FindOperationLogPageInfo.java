package com.partybuilding.webserver.dto.system.operationLog;

import javax.validation.constraints.NotNull;

/**
 * 查询系统日志记录请求对象
 */
public class FindOperationLogPageInfo {
    private String name; // 操作人姓名
    private String content; // 操作内容
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

    public FindOperationLogPageInfo() {
        this.name = "";
        this.content = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
