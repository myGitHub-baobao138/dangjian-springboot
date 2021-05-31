package com.partybuilding.webserver.dto.service.volunteer;

/**
 * author 包嵩
 */
public class KeywordSearchVolunteerDTO {
    /**
     * 输入的活动内容
     */
    private String content;

    /**
     * 选择的活动状态
     */
    private String approvalState;

    /**
     * 当前页面
     */
    private int currentPage;

    /**
     * 页数
     */
    private int pageSize;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getApprovalState() {
        return approvalState;
    }

    public void setApprovalState(String approvalState) {
        this.approvalState = approvalState;
    }
}
