package com.partybuilding.webserver.dto.dynamic.essay;

public class QueryEssayBodyDto {

    private String inputContent;
    private int checkStatus;
    private int source;
    private String organizationId;
    private int organizationRank;
    private String startTime;
    private String endTime;
    private int currentPage;
    private int pageSize;

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

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
    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
