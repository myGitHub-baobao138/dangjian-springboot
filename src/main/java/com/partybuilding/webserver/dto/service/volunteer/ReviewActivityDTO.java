package com.partybuilding.webserver.dto.service.volunteer;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 获取审核列表
 */
public class ReviewActivityDTO {
    /**
     * 活动标题
     */
    private String title;
    /**
     * 活动内容
     */
    private String content;
    /**
     * 发起人姓名
     */
    private String activitySponsorName;
    /**
     * 发起人身份
     */
    private String activitySponsorPost;
    /**
     * 投稿时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date submissionTime;
    /**
     * 审核状态
     */
    private String approvalState;
    /**
     * 审核人
     */
    private String reviewer;
    /**
     * 审核时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date reviewTime;

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

    public String getActivitySponsorPost() {
        return activitySponsorPost;
    }

    public void setActivitySponsorPost(String activitySponsorPost) {
        this.activitySponsorPost = activitySponsorPost;
    }

    public Date getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getApprovalState() {
        return approvalState;
    }

    public void setApprovalState(String approvalState) {
        this.approvalState = approvalState;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }
}
