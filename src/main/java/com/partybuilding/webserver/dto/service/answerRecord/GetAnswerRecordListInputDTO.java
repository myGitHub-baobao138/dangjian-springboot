package com.partybuilding.webserver.dto.service.answerRecord;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 获取答题列表DTO
 */
public class GetAnswerRecordListInputDTO {

    @NotNull(message = "当前页不能为空")
    @NotEmpty(message = "当前页不能为空串")
    private Integer currentPage;

    @NotNull(message = "当前页不能为空")
    @NotEmpty(message = "当前页不能为空串")
    private Integer pageSize;


    /**
     * 分类id
     */
    private String questionCategoryId;

    /**
     * 模糊查询标题和答题者
     */
    private String content;

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

    public String getQuestionCategoryId() {
        return questionCategoryId;
    }

    public void setQuestionCategoryId(String questionCategoryId) {
        this.questionCategoryId = questionCategoryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
