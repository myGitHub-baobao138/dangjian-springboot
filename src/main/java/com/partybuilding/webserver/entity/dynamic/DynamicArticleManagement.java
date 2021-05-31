package com.partybuilding.webserver.entity.dynamic;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DynamicArticleManagement {

    //文章/稿件id
    private String id;

    //文章/稿件标题
    private String title;

    //学院id(根据id查学院名 PS:“校级”也存为一个学院处理？)
    private String collegeId;

    //来源(来源于小程序的发布文章的党员先锋1或者基层风采2＋党主题日是3)
    // 也称类别
    private Integer source;

    //投稿人  （根据id查姓名）
    private String contributorId;

    //投稿时间
    private Date contributeTime;

    //审核状态(1:已通过0:未审核-1:未通过)
    private Integer checkStatus;

    //审核人id(根据id查姓名)
    private String reviewerId;

    //审核时间
    private Date checkTime;

    //审核说明
    private String checkDiscription;

    //下架人id(点赞管理的查看详情需要这个)
    // (根据id查姓名)
    private String cancelId;

    //下架时间
    private Date cancelTime;

    //下架说明
    private String cancelDiscription;

    //点赞数
    private Integer praiseAmount;

    //浏览量
    private String browsingAmount;

    //图片路径
    private String picUrl;

    //plugin_url
    private String pluginUrl;

    //稿件内容
    private String content;

   //是否置顶
    private Integer topSort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId == null ? null : collegeId.trim();
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getContributorId() {
        return contributorId;
    }

    public void setContributorId(String contributorId) {
        this.contributorId = contributorId == null ? null : contributorId.trim();
    }

    public Date getContributeTime() {
        return contributeTime;
    }

    public void setContributeTime(Date contributeTime) {
        this.contributeTime = contributeTime;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId == null ? null : reviewerId.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCheckDiscription() {
        return checkDiscription;
    }

    public void setCheckDiscription(String checkDiscription) {
        this.checkDiscription = checkDiscription == null ? null : checkDiscription.trim();
    }

    public String getCancelId() {
        return cancelId;
    }

    public void setCancelId(String cancelId) {
        this.cancelId = cancelId == null ? null : cancelId.trim();
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getCancelDiscription() {
        return cancelDiscription;
    }

    public void setCancelDiscription(String cancelDiscription) {
        this.cancelDiscription = cancelDiscription == null ? null : cancelDiscription.trim();
    }

    public Integer getPraiseAmount() {
        return praiseAmount;
    }

    public void setPraiseAmount(Integer praiseAmount) {
        this.praiseAmount = praiseAmount;
    }

    public String getBrowsingAmount() {
        return browsingAmount;
    }

    public void setBrowsingAmount(String browsingAmount) {
        this.browsingAmount = browsingAmount == null ? null : browsingAmount.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getPluginUrl() {
        return pluginUrl;
    }

    public void setPluginUrl(String pluginUrl) {
        this.pluginUrl = pluginUrl == null ? null : pluginUrl.trim();
    }

    public String getContent() {
        return content;
    }

    /**
     * 用于删除字符串的头尾空白符。
     * 语法：public String trim()
     * 返回值：删除头尾空白符的字符串。
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getTopSort() {
        return topSort;
    }

    public void setTopSort(Integer topSort) {
        this.topSort = topSort;
    }


}