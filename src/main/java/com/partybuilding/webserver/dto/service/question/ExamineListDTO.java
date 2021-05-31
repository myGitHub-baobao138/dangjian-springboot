package com.partybuilding.webserver.dto.service.question;

import com.partybuilding.webserver.entity.service.ServiceQuestion;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public class ExamineListDTO {
    private String id;
    private String title;
    private String categoryName; // 分类名称
    private String questionCategoryId; // 分类id
    private Integer questionsNumber; // 题目数
    private Integer respondentNumber; // 答题人数
    private String beginTime; // 开始时间
    private String endTime; // 结束时间
    private String founder; // 创建者
    private Integer state; // 状态
    private List<ServiceQuestion> questions; // 问题列表

    public List<ServiceQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<ServiceQuestion> questions) {
        this.questions = questions;
    }

    public Integer getRespondentNumber() {
        return respondentNumber;
    }

    public void setRespondentNumber(Integer respondentNumber) {
        this.respondentNumber = respondentNumber;
    }

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getQuestionCategoryId() {
        return questionCategoryId;
    }

    public void setQuestionCategoryId(String questionCategoryId) {
        this.questionCategoryId = questionCategoryId;
    }

    public Integer getQuestionsNumber() {
        return questionsNumber;
    }

    public void setQuestionsNumber(Integer questionsNumber) {
        this.questionsNumber = questionsNumber;
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

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


}
