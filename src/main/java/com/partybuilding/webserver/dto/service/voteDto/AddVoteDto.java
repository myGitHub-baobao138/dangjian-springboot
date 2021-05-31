package com.partybuilding.webserver.dto.service.voteDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.partybuilding.webserver.entity.service.ServiceVoteOption;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class AddVoteDto {
    //投票开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
//    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date voteBeginTime;
    //投票结束时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
//    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date voteEndTime;
    //发起人的id
    private String sysUserPartyId;
    //投票的选项
    private List<ServiceVoteOption> voteOption;
    //投票的状态
    private Integer voteStatus;
    //投票的内容
    private String voteContent;
    //投票的标题
    private String voteTitle;
    //所属组织id
    private String organizationId;

    private String voteId;

    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
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

    public List<ServiceVoteOption> getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(List<ServiceVoteOption> voteOption) {
        this.voteOption = voteOption;
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
        this.voteContent = voteContent;
    }

    public String getVoteTitle() {
        return voteTitle;
    }

    public void setVoteTitle(String voteTitle) {
        this.voteTitle = voteTitle;
    }
}
