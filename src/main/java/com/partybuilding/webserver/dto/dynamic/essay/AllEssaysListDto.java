package com.partybuilding.webserver.dto.dynamic.essay;

public class AllEssaysListDto {

    private String  organizationId;
    private int organizationRank;
    private int currentPage;
    private int pageSize;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public int getOrganizationRank() {
        return organizationRank;
    }

    public void setOrganizationRank(int organizationRank) {
        this.organizationRank = organizationRank;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
