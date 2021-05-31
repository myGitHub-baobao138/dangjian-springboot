package com.partybuilding.webserver.dto.dynamic.cultivate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CreateCultivateEssayInDto {

    @NotEmpty(message = "标题不能为空")
    private String title; // 标题
    //设置文章id
    private String id;
    //网址
    private String outsiteUrl;
    //内容
    private String content;
    //图片
    private String picUrl;
    //附件
    private String pluginUrl;
    //发布时间
    private Date publishTime;
    //发布人
    @NotNull(message = "发布人id不为空")
    private String editorId;

    //组织id
    private String organizationId;
    //状态
    private int publishStatus;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOutsiteUrl() {
        return outsiteUrl;
    }

    public void setOutsiteUrl(String outsiteUrl) {
        this.outsiteUrl = outsiteUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        this.editorId = editorId;
    }

    public int getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(int publishStatus) {
        this.publishStatus = publishStatus;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
}
