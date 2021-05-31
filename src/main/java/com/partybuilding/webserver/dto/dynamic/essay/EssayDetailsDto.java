package com.partybuilding.webserver.dto.dynamic.essay;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
    * Created with IntelliJ IDEA.
    * @Description: 查看稿件详情页面
    */
public class EssayDetailsDto {

    /**
     * 文章/稿件id
     */
    private String id;

    /**
     * 稿件标题
     */
    private String title;

    /**
     * 稿件内容
     */
    private String content;

    /**
     * 来源(来源于小程序-发布文章-
     * 党员先锋1
     * 基层风采2
     * 党主题日3)
     * 也称类别
     */
    private Integer source;

    /**
     * 投稿人
     */
    private String contributor;

    /**
     * 投稿人 对应 党员职位
     */
    private String position;

    /**
     * 投稿时间
     */

    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date contributeTime;

    /**
     * 审核状态
     * 1:已通过
     * 0:未审核
     * -1:未通过
     */
    private Integer checkStatus;

    /**
     * 图片路径
     */
    private String picUrl;

    /**
     * 附件路径
     */
    private String pluginUrl;

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

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
}
