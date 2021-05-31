package com.partybuilding.webserver.dto.dynamic.clickLike;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ClickLikeDetaislDto {
  @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
  private String clickTime;
  private String clickPersonName;
  private String clickPersonPosition;
  private String id;  //点赞记录id
  private String articleId;  //文章id

  public String getArticleId() {
    return articleId;
  }

  public void setArticleId(String articleId) {
    this.articleId = articleId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getClickTime() {
    return clickTime;
  }

  public void setClickTime(String clickTime) {
    this.clickTime = clickTime;
  }

  public String getClickPersonName() {
    return clickPersonName;
  }

  public void setClickPersonName(String clickPersonName) {
    this.clickPersonName = clickPersonName;
  }

  public String getClickPersonPosition() {
    return clickPersonPosition;
  }

  public void setClickPersonPosition(String clickPersonPosition) {
    this.clickPersonPosition = clickPersonPosition;
  }
}
