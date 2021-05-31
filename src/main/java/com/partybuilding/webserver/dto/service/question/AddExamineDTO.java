package com.partybuilding.webserver.dto.service.question;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 添加考题
 */
public class AddExamineDTO {
    private String id;
    /**
     * 标题
     */
    private String title;

    /**
     * 开始时间
     */
    private String beginTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 发布时间
     */
    private String releaseTime;

    /**
     * 所属分类
     */
    private String questionCategory;

    /**
     * 创建人id
     */
    private String founderId;

    /**
     * 创建人组织id
     */
    private String founderOrganizationId;

    /**
     * 问题id列表
     */
    private List<String> questionId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFounderOrganizationId() {
        return founderOrganizationId;
    }

    public void setFounderOrganizationId(String founderOrganizationId) {
        this.founderOrganizationId = founderOrganizationId;
    }

    public List<String> getQuestionId() {
        return questionId;
    }

    public void setQuestionId(List<String> questionId) {
        this.questionId = questionId;
    }

    public String getFounderId() {
        return founderId;
    }

    public void setFounderId(String founderId) {
        this.founderId = founderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(String questionCategory) {
        this.questionCategory = questionCategory;
    }
}
