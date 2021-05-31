package com.partybuilding.webserver.entity.service;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 投票调查类
 */
public class ServiceVote implements Serializable {
    /**
     * id
     */
    private String voteId;
    //投票开始时间
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    private Date voteBeginTime;
    //投票结束时间
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    private Date voteEndTime;
    //发起人的id
    private String sysUserPartyId;

    //投票的状态
    private Integer voteStatus;
    //投票的内容
    private String voteContent;
    //投票的标题
    private String voteTitle;
    //所属院校
    private String organizationId;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getVoteTitle() {
        return voteTitle;
    }

    public void setVoteTitle(String voteTitle) {
        this.voteTitle = voteTitle==null?null : voteTitle.trim();
    }

    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId == null ? null : voteId.trim();
    }

    public Date getVoteBeginTime() {
        return voteBeginTime;
    }

    public void setVoteBeginTime(Date voteBeginTime) {
        this.voteBeginTime = voteBeginTime;
    }

    public Date getVoteEndTime() {
        return voteEndTime;
    }

    public void setVoteEndTime(Date voteEndTime) {
        this.voteEndTime = voteEndTime;
    }

    public String getSysUserPartyId() {
        return sysUserPartyId;
    }

    public void setSysUserPartyId(String sysUserPartyId) {
        this.sysUserPartyId = sysUserPartyId;
    }

    public Integer getVoteStatus() {
        return voteStatus;
    }

    public void setVoteStatus(Integer voteStatus) {
        this.voteStatus = voteStatus;
    }

    public String getVoteContent() {
        return voteContent;
    }

    public void setVoteContent(String voteContent) {
        this.voteContent = voteContent == null ? null : voteContent.trim();
    }
}