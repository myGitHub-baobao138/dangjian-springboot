package com.partybuilding.webserver.entity.system;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SysOperationLog {
    private String id;
    @JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss",timezone = "GMT+8")
    private Date operationTime;

    private String operationContent;

    private String operationPage;

    private String partyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperationContent() {
        return operationContent;
    }

    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent == null ? null : operationContent.trim();
    }

    public String getOperationPage() {
        return operationPage;
    }

    public void setOperationPage(String operationPage) {
        this.operationPage = operationPage == null ? null : operationPage.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }
}