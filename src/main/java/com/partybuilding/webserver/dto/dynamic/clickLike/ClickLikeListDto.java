package com.partybuilding.webserver.dto.dynamic.clickLike;


//根据点赞数到点赞列表得到点赞列表的数据
public class ClickLikeListDto {
  private int currentPage;
  private int pageSize;

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

  public String getArticleId() {
    return articleId;
  }

  public void setArticleId(String articleId) {
    this.articleId = articleId;
  }

  private String articleId;

}
