package com.partybuilding.webserver.dto.dynamic.essay;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * @Description: 文章发布管理
 */
public class PublishEssayDto {

    //文章id
    private String id;

    //学院（组织）名称
    private String academy;

    //文章标题
    private String title;

    //文章内容
    private String content;

    //文章来源 1-党员先锋 2-基层风采 3-党主题日
    private Integer source;

    //投稿人姓名
    private String contributor;

    //投稿时间
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date contributeTime;

    //文章状态 1-已发布  -2：草稿状态
    private Integer essayStatus;

    //发布时间
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date publishTime;

    //下架时间
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date outTime;

    private int isTop;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
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

    public Date getContributeTime() {
        return contributeTime;
    }

    public void setContributeTime(Date contributeTime) {
        this.contributeTime = contributeTime;
    }

    public Integer getEssayStatus() {
        return essayStatus;
    }

    public void setEssayStatus(Integer essayStatus) {
        this.essayStatus = essayStatus;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public int getIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }
}
