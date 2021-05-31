package com.partybuilding.webserver.dto.dynamic.cultivate;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class modifyEssayInDto {

    //文章的id
    @NotNull(message = "文章id不为空")
    private String essayId;
    //文章的标题
    private String title;
    //文章的内容
    private String content;
    //文章发布的人员
    private String editorId;
    //组织id
    private String organizationId;
    //文章发布时间
    private Date publishTime;
    //状态：预览为0  已发布为1
    private int publishStatus;
    //网址
    private String outsiteUrl;
    //图片路径
    private String picUrl;
    //附件路径
    private String pluginUrl;

    public String getEssayId() {
        return essayId;
    }

    public void setEssayId(String essayId) {
        this.essayId = essayId;
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

    public String getEditorId() {
        return editorId;
    }

    public void setEditorId(String editorId) {
        this.editorId = editorId;
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

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
}
