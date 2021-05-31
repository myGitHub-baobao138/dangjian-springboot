package com.partybuilding.webserver.dto.service.voteDto;

import java.util.List;

public class VoteInfoListDto {
    private String id;
    //标题
    private String title;
    //内容
    private String content;
    //发布人党员名称
    private String partyName;
    //组织名称
    private String organizationName;
    //选项列举
    private String option;
    //开始结束时间
    private String beginTimeAndEndTime;
    //状态
    private Integer status;

    private String maxOption;

    private String noSubTime;

    private List<VoteOptionAndNumberDto> list;

    public String getNoSubTime() {
        return noSubTime;
    }

    public void setNoSubTime(String noSubTime) {
        this.noSubTime = noSubTime;
    }

    public List<VoteOptionAndNumberDto> getList() {
        return list;
    }

    public void setList(List<VoteOptionAndNumberDto> list) {
        this.list = list;
    }

    public String getMaxOption() {
        return maxOption;
    }

    public void setMaxOption(String maxOption) {
        this.maxOption = maxOption;
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

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getBeginTimeAndEndTime() {
        return beginTimeAndEndTime;
    }

    public void setBeginTimeAndEndTime(String beginTimeAndEndTime) {
        this.beginTimeAndEndTime = beginTimeAndEndTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
