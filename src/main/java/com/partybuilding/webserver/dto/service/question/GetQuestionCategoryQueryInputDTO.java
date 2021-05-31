package com.partybuilding.webserver.dto.service.question;

/**
 * Created with IntelliJ IDEA.
 * @Description:
 */
public class GetQuestionCategoryQueryInputDTO {
    private String categoryName; // 分类名称
    private Integer currentPage; // 当前页
    private Integer pageSize; // 每页数量

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
