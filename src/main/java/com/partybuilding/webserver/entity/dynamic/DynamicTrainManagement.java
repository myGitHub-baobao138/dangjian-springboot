package com.partybuilding.webserver.entity.dynamic;

import java.util.Date;

public class DynamicTrainManagement {
    private String id;

    private String title;

    private Date publishTime;

    private String editorId;

    private Integer publishStatus;

    private Integer browsingAmount;

    private Integer praiseAmount;

    private String outsiteUrl;

    private String picUrl;

    private String pluginUrl;

    private String content;

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

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getEditorId() {
        return editorId;
    }

    public void setEditorId(String editorId) {
        this.editorId = editorId == null ? null : editorId.trim();
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getBrowsingAmount() {
        return browsingAmount;
    }

    public void setBrowsingAmount(Integer browsingAmount) {
        this.browsingAmount = browsingAmount;
    }

    public Integer getPraiseAmount() {
        return praiseAmount;
    }

    public void setPraiseAmount(Integer praiseAmount) {
        this.praiseAmount = praiseAmount;
    }

    public String getOutsiteUrl() {
        return outsiteUrl;
    }

    public void setOutsiteUrl(String outsiteUrl) {
        this.outsiteUrl = outsiteUrl == null ? null : outsiteUrl.trim();
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

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}