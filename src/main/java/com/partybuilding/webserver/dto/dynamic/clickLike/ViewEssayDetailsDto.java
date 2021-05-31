package com.partybuilding.webserver.dto.dynamic.clickLike;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ViewEssayDetailsDto {
  /**
   * /文章id
   */
  private String titleId;
  /**
   * 文章来源
   * 1  党员先锋
   * 2  基层风采‘
   * 3 党主题日
   * 4 志愿活动
   * 5 党校培训
   */
  private int source;
  /**
   * 文章题目
   */
  private String title;
  //投稿人姓名
  private String contributorName;
  //投稿人职务
  private String position;
  //投稿时间
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date contributeTime;

  //文章审核之后被发布的发布时间
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date publishTime;
  //文章内容
  private String content;
  //图片路径
  private String picPath;
  //文章状态(被审核、被下架  志愿活动表： 1-未审核、2-未通过、3-审核通过  )
  private int state;
  //文章审核人
  private String reviewerName;

  //文章下架人
  private String cancelName;

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
//志愿活动表所需要的相关属性

  private String contactNumber;     //联系人方式
  private String meetingPlace;      //集合地点
  private String activityLocation;  //活动地点
  private String activitySponsor;   //活动发起人
  private String activityState;     //活动状态（1-未发布、2-报名中、3-报名截止、4-活动结束）
 @JsonFormat(pattern = "yyyy-MM-dd")
  private Date registrationEndTime;   //活动报名截止时间

  public String getTitleId() {
    return titleId;
  }

  public void setTitleId(String titleId) {
    this.titleId = titleId;
  }

  public int getSource() {
    return source;
  }

  public void setSource(int source) {
    this.source = source;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContributorName() {
    return contributorName;
  }

  public void setContributorName(String contributorName) {
    this.contributorName = contributorName;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }



  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getPicPath() {
    return picPath;
  }

  public void setPicPath(String picPath) {
    this.picPath = picPath;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public String getReviewerName() {
    return reviewerName;
  }

  public void setReviewerName(String reviewerName) {
    this.reviewerName = reviewerName;
  }

  public String getCancelName() {
    return cancelName;
  }

  public void setCancelName(String cancelName) {
    this.cancelName = cancelName;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getMeetingPlace() {
    return meetingPlace;
  }

  public void setMeetingPlace(String meetingPlace) {
    this.meetingPlace = meetingPlace;
  }

  public String getActivityLocation() {
    return activityLocation;
  }

  public void setActivityLocation(String activityLocation) {
    this.activityLocation = activityLocation;
  }

  public String getActivitySponsor() {
    return activitySponsor;
  }

  public void setActivitySponsor(String activitySponsor) {
    this.activitySponsor = activitySponsor;
  }

  public String getActivityState() {
    return activityState;
  }

  public void setActivityState(String activityState) {
    this.activityState = activityState;
  }

  public Date getRegistrationEndTime() {
    return registrationEndTime;
  }

  public void setRegistrationEndTime(Date registrationEndTime) {
    this.registrationEndTime = registrationEndTime;
  }
}
