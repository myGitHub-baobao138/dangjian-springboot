package com.partybuilding.webserver.dto.system.announcement;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SearchAnnouncementDto {
    //根据内容搜索
    String content;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    String publishTime;

    Integer currentPage;

    Integer pageSize;

    String organizationId;

    Integer rank;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
