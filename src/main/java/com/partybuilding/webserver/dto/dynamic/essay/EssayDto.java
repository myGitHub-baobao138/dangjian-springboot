package com.partybuilding.webserver.dto.dynamic.essay;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * @Description: 返回的稿件审核列表结果类
 */

public class EssayDto {
    /**
     * 文章/稿件id
     */
    private String id;

    /**
     * 学院
     */
    private String academyName;

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
     * 审核人
     */
    private String reviewer;

    /**
     *审核时间
     **/
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date checkTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
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

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date reviewTime) {
        this.checkTime = reviewTime;
    }
}
