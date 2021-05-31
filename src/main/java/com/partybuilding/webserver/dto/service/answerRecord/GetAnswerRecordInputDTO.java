package com.partybuilding.webserver.dto.service.answerRecord;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public class GetAnswerRecordInputDTO {
    @NotNull(message = "当前页不能为空")
    @NotEmpty(message = "当前页不能为空串")
    private Integer currentPage;

    @NotNull(message = "当前页不能为空")
    @NotEmpty(message = "当前页不能为空串")
    private Integer pageSize;


    /**
     * 记录id
     */
    private String answerRecordId;

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

    public String getAnswerRecordId() {
        return answerRecordId;
    }

    public void setAnswerRecordId(String answerRecordId) {
        this.answerRecordId = answerRecordId;
    }
}
