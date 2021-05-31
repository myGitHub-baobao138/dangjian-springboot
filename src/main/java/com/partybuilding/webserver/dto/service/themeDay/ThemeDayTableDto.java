package com.partybuilding.webserver.dto.service.themeDay;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ThemeDayTableDto {

    private String id;

    private String organizationName;//支部名称

    private String branchSecretaryName;//支部书记

    private String title;

//    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss",timezone = "GMT+8")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date releaseTime;

    private String editorName;

    private String status;

    private String viewsNumber;

    private String likesNumber;

    private String top;//是否置顶

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getBranchSecretaryName() {
        return branchSecretaryName;
    }

    public void setBranchSecretaryName(String branchSecretaryName) {
        this.branchSecretaryName = branchSecretaryName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getEditorName() {
        return editorName;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getViewsNumber() {
        return viewsNumber;
    }

    public void setViewsNumber(String viewsNumber) {
        this.viewsNumber = viewsNumber;
    }

    public String getLikesNumber() {
        return likesNumber;
    }

    public void setLikesNumber(String likesNumber) {
        this.likesNumber = likesNumber;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }
}
