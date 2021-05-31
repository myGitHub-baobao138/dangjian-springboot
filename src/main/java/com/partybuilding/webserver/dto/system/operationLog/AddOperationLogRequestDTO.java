package com.partybuilding.webserver.dto.system.operationLog;

import javax.validation.constraints.NotEmpty;

/**
 * 添加系统日志记录请求对象
 */
public class AddOperationLogRequestDTO {
    @NotEmpty(message = "当前操作人党员id不能为空")
    private String partyId; // 当前操作人党员 id
    @NotEmpty(message = "操作页面不能为空")
    private String operationPage; // 操作页面
    @NotEmpty(message = "操作内容不能为空")
    private String operationContent; // 操作内容

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getOperationPage() {
        return operationPage;
    }

    public void setOperationPage(String operationPage) {
        this.operationPage = operationPage;
    }

    public String getOperationContent() {
        return operationContent;
    }

    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent;
    }
}
