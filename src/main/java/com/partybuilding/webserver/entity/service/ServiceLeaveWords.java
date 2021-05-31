package com.partybuilding.webserver.entity.service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 学院管理实体类
 */
public class ServiceLeaveWords {
    private String id;

    private Date leaveWordsTime;

    private String wxUserId;

    private String userId;

    private Date replyTime;

    private String leaveWordsContent;

    private String replyContent;

    private String leaveOrganizationId;
    private String leavePostId;
    private String replyOrganizationId;
    private String replyPostId;


    public String getLeaveOrganizationId() {
        return leaveOrganizationId;
    }

    public void setLeaveOrganizationId(String leaveOrganizationId) {
        this.leaveOrganizationId = leaveOrganizationId;
    }

    public String getLeavePostId() {
        return leavePostId;
    }

    public void setLeavePostId(String leavePostId) {
        this.leavePostId = leavePostId;
    }

    public String getReplyOrganizationId() {
        return replyOrganizationId;
    }

    public void setReplyOrganizationId(String replyOrganizationId) {
        this.replyOrganizationId = replyOrganizationId;
    }

    public String getReplyPostId() {
        return replyPostId;
    }

    public void setReplyPostId(String replyPostId) {
        this.replyPostId = replyPostId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getLeaveWordsTime() {
        return leaveWordsTime;
    }

    public void setLeaveWordsTime(Date leaveWordsTime) {
        this.leaveWordsTime = leaveWordsTime;
    }

    public String getWxUserId() {
        return wxUserId;
    }

    public void setWxUserId(String wxUserId) {
        this.wxUserId = wxUserId == null ? null : wxUserId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getLeaveWordsContent() {
        return leaveWordsContent;
    }

    public void setLeaveWordsContent(String leaveWordsContent) {
        this.leaveWordsContent = leaveWordsContent == null ? null : leaveWordsContent.trim();
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }
}