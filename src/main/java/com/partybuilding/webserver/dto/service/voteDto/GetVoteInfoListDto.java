package com.partybuilding.webserver.dto.service.voteDto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

public class GetVoteInfoListDto {
    private String id;
    //标题
    private String title;
    //内容
    private String content;
    //发布人党员名称
    private String partyName;
    //组织名称
    private String organizationName;

    //开始结束时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone ="GMT+8" )
    private String beginTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone ="GMT+8" )
    private String endTime;
    //状态
    private Integer status;

    private List<VoteOptionAndNumberDto> list;

    public List<VoteOptionAndNumberDto> getList() {
        return list;
    }

    public void setList(List<VoteOptionAndNumberDto> list) {
        this.list = list;
    }

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

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }



    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
