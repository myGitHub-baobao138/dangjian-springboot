package com.partybuilding.webserver.dto.service.leavewords;


/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 留言列表返回结果类
 */
public class LeaveWordsListDTO {
    /**
     * 留言id
     */

    private String id;
    /**
     * 留言内容
     */
    private String leaveWordsContent;

    /**
     * 留言者姓名
     */
    private String leaveWordsName;

    /**
     * 留言者职务
     */
    private String leaveWordsPosition;

    /**
     * 回复人职务
     */
    private String replyPosition;

    /**
     * 留言时间
     */
    private String leaveWordsTime;

    /**
     * 回复人姓名
     */
    private String replyName;

    /**
     * 回复时间
     */
    private String replyTime;

    /**
     * 回复内容
     */
    private String replyContent;

    /**
     * 回复人组织
     */
    private String replyOrganizationName;

    /**
     * 留言者组织
     */
    private String leaveOrganizationName;

    public String getReplyPosition() {
        return replyPosition;
    }

    public void setReplyPosition(String replyPosition) {
        this.replyPosition = replyPosition;
    }

    public String getReplyOrganizationName() {
        return replyOrganizationName;
    }

    public void setReplyOrganizationName(String replyOrganizationName) {
        this.replyOrganizationName = replyOrganizationName;
    }

    public String getLeaveOrganizationName() {
        return leaveOrganizationName;
    }

    public void setLeaveOrganizationName(String leaveOrganizationName) {
        this.leaveOrganizationName = leaveOrganizationName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeaveWordsContent() {
        return leaveWordsContent;
    }

    public void setLeaveWordsContent(String leaveWordsContent) {
        this.leaveWordsContent = leaveWordsContent;
    }

    public String getLeaveWordsName() {
        return leaveWordsName;
    }

    public void setLeaveWordsName(String leaveWordsName) {
        this.leaveWordsName = leaveWordsName;
    }

    public String getLeaveWordsPosition() {
        return leaveWordsPosition;
    }

    public void setLeaveWordsPosition(String leaveWordsPosition) {
        this.leaveWordsPosition = leaveWordsPosition;
    }

    public String getLeaveWordsTime() {
        return leaveWordsTime;
    }

    public void setLeaveWordsTime(String leaveWordsTime) {
        this.leaveWordsTime = leaveWordsTime;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

}
