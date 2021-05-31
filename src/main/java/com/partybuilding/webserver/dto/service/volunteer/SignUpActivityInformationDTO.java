package com.partybuilding.webserver.dto.service.volunteer;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 活动报名管理——显示活动列表
 */
public class SignUpActivityInformationDTO {
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 发起人
     */
    private String activitySponsorName;
    /**
     * 报名截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date registrationDeadline;
    /**
     * 状态
     */
    private String activityState;
    /**
     * 报名人数
     */
    private String signUpNumber;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getActivitySponsorName() {
        return activitySponsorName;
    }

    public void setActivitySponsorName(String activitySponsorName) {
        this.activitySponsorName = activitySponsorName;
    }

    public Date getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(Date registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }

    public String getActivityState() {
        return activityState;
    }

    public void setActivityState(String activityState) {
        this.activityState = activityState;
    }

    public String getSignUpNumber() {
        return signUpNumber;
    }

    public void setSignUpNumber(String signUpNumber) {
        this.signUpNumber = signUpNumber;
    }
}
