package com.partybuilding.webserver.dto.dynamic.clickLike;
//得到点赞列表数据时需要传的参数的类
public class ClickLikeDataDto {
  private int currentPage;
  private int pageSize;
  private String organizationId;
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
}
