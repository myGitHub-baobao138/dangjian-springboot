package com.partybuilding.webserver.entity.service;

public class ServiceAnswerDetails {
    private String id;

    private String answerRecordId;

    private String answerContent;

    private String questionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAnswerRecordId() {
        return answerRecordId;
    }

    public void setAnswerRecordId(String answerRecordId) {
        this.answerRecordId = answerRecordId == null ? null : answerRecordId.trim();
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent == null ? null : answerContent.trim();
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }
}