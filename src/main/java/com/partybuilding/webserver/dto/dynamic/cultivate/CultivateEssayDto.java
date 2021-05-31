package com.partybuilding.webserver.dto.dynamic.cultivate;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CultivateEssayDto {
    //文章的id
    private String id;
    //文章的标题
    private String title;
    //文章的内容
    private String content;
    //文章发布的人员
    private String editorName;
    //文章发布时间
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    private Date publishTime;
    //状态：预览为0  已发布为1
    private int publishStatus;
    //网址
    private String outsiteUrl;
    //图片路径
    private String picUrl;
    //附件路径
    private String pluginUrl;
    //阅览量
    private int browsingAmount;
    //点赞数
    private int praiseAmount;

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

    public String getEditorName() {
        return editorName;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public int getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(int publishStatus) {
        this.publishStatus = publishStatus;
    }

    public String getOutsiteUrl() {
        return outsiteUrl;
    }

    public void setOutsiteUrl(String outsiteUrl) {
        this.outsiteUrl = outsiteUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPluginUrl() {
        return pluginUrl;
    }

    public void setPluginUrl(String pluginUrl) {
        this.pluginUrl = pluginUrl;
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
}
