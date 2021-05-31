package com.partybuilding.webserver.entity.service;

import java.util.Date;

public class ServiceAnswerRecord {
    private String id;

    private String examinationId;

    private String userId;

    private Date answerTime;

    private Integer questionTotalNumber;

    private Integer correctQuestionNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(String examinationId) {
        this.examinationId = examinationId == null ? null : examinationId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public Integer getQuestionTotalNumber() {
        return questionTotalNumber;
    }

    public void setQuestionTotalNumber(Integer questionTotalNumber) {
        this.questionTotalNumber = questionTotalNumber;
    }

    public Integer getCorrectQuestionNumber() {
        return correctQuestionNumber;
    }

    public void setCorrectQuestionNumber(Integer correctQuestionNumber) {
        this.correctQuestionNumber = correctQuestionNumber;
    }
}