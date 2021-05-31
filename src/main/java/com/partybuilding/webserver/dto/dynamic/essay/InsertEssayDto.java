package com.partybuilding.webserver.dto.dynamic.essay;

import java.util.Date;

public class InsertEssayDto {

    private String id;
    private String title;
    private String content;
    private int source;
    private String organizationId;
    private String contributorId;
    private Date contributeTime;
    private Date checkTime;
    private int checkStatus;
    private String picUrl;
    private String pluginUrl;
    private int topSort;
    private String operatorId;
    private String operatorName;


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

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public Date getContributeTime() {
        return contributeTime;
    }

    public void setContributeTime(Date contributeTime) {
        this.contributeTime = contributeTime;
    }

    public String getContributorId() {
        return contributorId;
    }

    public void setContributorId(String contributorId) {
        this.contributorId = contributorId;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
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

    public int getTopSort() {
        return topSort;
    }

    public void setTopSort(int topSort) {
        this.topSort = topSort;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
