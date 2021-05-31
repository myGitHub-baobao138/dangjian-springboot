package com.partybuilding.webserver.dto.dynamic.clickLike;

//通过搜索得到相应的点赞记录（输入内容、发布时间）
public class ClickLikeQueryDataDto {
  private int currentPage;
  private int pageSize;
  private String organizationId;
  private String inputContent;
  private String startTime;
  private String endTime;
  private int organizationRank;

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

  public String getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

  public String getInputContent() {
    return inputContent;
  }

  public void setInputContent(String inputContent) {
    this.inputContent = inputContent;
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
