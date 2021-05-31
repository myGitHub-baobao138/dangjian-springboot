package com.partybuilding.webserver.dto.service.voteDto;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ServiceVoteDto implements Serializable {
    /**
     * id
     */
    private String voteId;
    //投票开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date voteBeginTime;
    //投票结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date voteEndTime;
    //发起人的id
    private String partyId;
    //投票的选项
    private List<ServiceVoteOptionDto> voteOption;
    //字符串选项
    private String strVoteOption;
    //投票的状态
    private Integer voteStatus;
    //投票的内容
    private String voteContent;
    //投票的标题
    private String voteTitle;
    //所属院校
    private String sysUserDepartment;

    public String getStrVoteOption() {
        return strVoteOption;
    }

    public void setStrVoteOption(String strVoteOption) {
        this.strVoteOption = strVoteOption;
    }

    public String getSysUserDepartment() {
        return sysUserDepartment;
    }

    public void setSysUserDepartment(String sysUserDepartment) {
        this.sysUserDepartment = sysUserDepartment;
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

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public List<ServiceVoteOptionDto> getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(List<ServiceVoteOptionDto> voteOption) {
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
        this.voteContent = voteContent == null ? null : voteContent.trim();
    }
}
