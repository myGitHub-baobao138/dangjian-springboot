package com.partybuilding.webserver.dto.service.question;

/**
 * 编辑问题
 */
public class EditQuestionDTO {
    /**
     * 问题id
     */
    private String id;
    /**
     * 题目
     */
    private String title;
    /**
     * 问题
     */
    private String question;

    /**
     * 问题类型
     */
    private String questionType;
    /**
     * 问题描述
     */
    private String answerDescription;
    /**
     * 正确答案
     */
    private String correctAnswer;
    /**
     * 图片
     */
    private String picture;

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerDescription() {
        return answerDescription;
    }

    public void setAnswerDescription(String answerDescription) {
        this.answerDescription = answerDescription;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
