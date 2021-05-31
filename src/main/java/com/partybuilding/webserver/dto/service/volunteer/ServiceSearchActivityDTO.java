package com.partybuilding.webserver.dto.service.volunteer;

/**
 * 查询活动
 */
public class ServiceSearchActivityDTO {
    private String value;

    private Integer currentPage;

    private Integer pageSize;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
