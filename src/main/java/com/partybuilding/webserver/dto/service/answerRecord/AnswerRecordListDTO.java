package com.partybuilding.webserver.dto.service.answerRecord;

import com.partybuilding.webserver.entity.service.ServiceQuestion;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 答题记录列表DTO
 */
public class AnswerRecordListDTO {
    private String answerRecordId;
    private String title;
    private String questionCategoryName;
    private String answerer;
    private List<String> position;
    private String partyId;
    private String examineId;
    private Integer correctQuestionNumber;
    private String answerTime;
    private double correctRate;
    private List<Question> questions;
    private Integer questionTotal;


    public String getExamineId() {
        return examineId;
    }

    public void setExamineId(String examineId) {
        this.examineId = examineId;
    }

    public Integer getQuestionTotal() {
        return questionTotal;
    }

    public void setQuestionTotal(Integer questionTotal) {
        this.questionTotal = questionTotal;
    }

    public List<String> getPosition() {
        return position;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getTitle() {
        return title;
    }

    public void setPosition(List<String> position) {
        this.position = position;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getAnswerRecordId() {
        return answerRecordId;
    }

    public void setAnswerRecordId(String answerRecordId) {
        this.answerRecordId = answerRecordId;
    }

    public String getQuestionCategoryName() {
        return questionCategoryName;
    }

    public void setQuestionCategoryName(String questionCategoryName) {
        this.questionCategoryName = questionCategoryName;
    }

    public String getAnswerer() {
        return answerer;
    }

    public void setAnswerer(String answerer) {
        this.answerer = answerer;
    }

    public Integer getCorrectQuestionNumber() {
        return correctQuestionNumber;
    }

    public void setCorrectQuestionNumber(Integer correctQuestionNumber) {
        this.correctQuestionNumber = correctQuestionNumber;
    }

    public String getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(String answerTime) {
        this.answerTime = answerTime;
    }

    public double getCorrectRate() {
        return correctRate;
    }

    public void setCorrectRate(double correctRate) {
        this.correctRate = correctRate;
    }
}
