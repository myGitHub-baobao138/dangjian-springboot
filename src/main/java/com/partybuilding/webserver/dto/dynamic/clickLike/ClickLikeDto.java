package com.partybuilding.webserver.dto.dynamic.clickLike;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 *
 */
public class ClickLikeDto {
  private String id;
  private String title;
  private String content;
  private String source;

  @JsonFormat(pattern = "yyyy/MM/dd")
  private Date contributeTime;

  @JsonFormat(pattern = "yyyy/MM/dd")
  private Date publishTime;

  public Date getContributeTime() {
    return contributeTime;
  }

  public void setContributeTime(Date contributeTime) {
    this.contributeTime = contributeTime;
  }

  public Date getPublishTime() {
    return publishTime;
  }

  public void setPublishTime(Date publishTime) {
    this.publishTime = publishTime;
  }

  private int browsingAmount;
  private int praiseAmount;
  private String academy;
  private String contributor;
  private int type;

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }





  public int getBrowsingAmount() {
    return browsingAmount;
  }

  public void setBrowsingAmount(int browsingAmount) {
    this.browsingAmount = browsingAmount;
  }

  public int getPraiseAmount() {
    return praiseAmount;
  }

  public void setPraiseAmount(int praiseAmount) {
    this.praiseAmount = praiseAmount;
  }

  public String getAcademy() {
    return academy;
  }

  public void setAcademy(String academy) {
    this.academy = academy;
  }

  public String getContributor() {
    return contributor;
  }

  public void setContributor(String contributor) {
    this.contributor = contributor;
  }

  @Override
  public String toString() {
    return "ClickLikeDto{" +
      "id='" + id + '\'' +
      ", title='" + title + '\'' +
      ", content='" + content + '\'' +
      ", source='" + source + '\'' +
      ", contributeTime='" + contributeTime + '\'' +
      ", publishTime='" + publishTime + '\'' +
      ", browsingAmount=" + browsingAmount +
      ", praiseAmount=" + praiseAmount +
      ", academy='" + academy + '\'' +
      ", contributor='" + contributor + '\'' +
      '}';
  }
}
