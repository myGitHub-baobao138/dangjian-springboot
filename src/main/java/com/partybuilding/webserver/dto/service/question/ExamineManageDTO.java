package com.partybuilding.webserver.dto.service.question;

/**
 * Created with IntelliJ IDEA.
 * @Description: 新增考题DTO
 */
public class ExamineManageDTO {
    private String id;

    private String title;


    private String beginTime;


    private String endTime;


    private String releaseTime;

    private String questionCategoryId;

    private String founderId;

    private Integer state;

    private String founderOrganizationId;

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

    public String getQuestionCategoryId() {
        return questionCategoryId;
    }

    public void setQuestionCategoryId(String questionCategoryId) {
        this.questionCategoryId = questionCategoryId;
    }

    public String getFounderId() {
        return founderId;
    }

    public void setFounderId(String founderId) {
        this.founderId = founderId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getFounderOrganizationId() {
        return founderOrganizationId;
    }

    public void setFounderOrganizationId(String founderOrganizationId) {
        this.founderOrganizationId = founderOrganizationId;
    }
}
