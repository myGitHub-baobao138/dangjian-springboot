package com.partybuilding.webserver.dto.system.operationLog;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OperationLogDTO {
    private String id; // 操作id
    @JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss",timezone = "GMT+8")
    private Date operationDate; // 操作日期
    private String operationContent; // 操作内容
    private String operationPage; // 操作页面
    private String operatorName; // 操作人名称
    private String postName; // 操作人职务

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public String getOperationContent() {
        return operationContent;
    }

    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent;
    }

    public String getOperationPage() {
        return operationPage;
    }

    public void setOperationPage(String operationPage) {
        this.operationPage = operationPage;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }
}
