package com.partybuilding.webserver.dto.service.leavewords;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 回复留言数据输入类
 */
public class ReplyLeaveWordsInputDTO {
    /**
     * 回复人id
     */
    @NotNull(message = "回复人id不能为空")
    @NotEmpty(message = "回复人id不能为空串")
    private String replyPartyId;

    /**
     * 留言id
     */
    @NotNull(message = "留言id不能为空")
    @NotEmpty(message = "留言id不能为空串")
    private String leaveWordsId;

    /**
     * 回复时间
     */
    @NotNull(message = "回复时间不能为空")
    @NotEmpty(message = "回复时间不能为空串")
    @Pattern(message = "时间格式必须是yyyy-MM-dd HH:mm:ss", regexp = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$")
    private String replyTime;

    /**
     * 回复内容
     */
    @NotNull(message = "回复内容不能为空")
    @NotEmpty(message = "回复内容不能为空串")
    private String replyContent;

    /**
     * 组织id
     */
    @NotNull(message = "回复人组织id")
    @NotEmpty(message = "回复人组织id不能为空串")
    private String replyOrganizationId;


    /**
     * 职务id
     */
    @NotNull(message = "回复职务id")
    @NotEmpty(message = "回复人职务id不能为空串")
    private String replyPostId;


    public String getReplyOrganizationId() {
        return replyOrganizationId;
    }

    public void setReplyOrganizationId(String replyOrganizationId) {
        this.replyOrganizationId = replyOrganizationId;
    }

    public String getReplyPostId() {
        return replyPostId;
    }

    public void setReplyPostId(String replyPostId) {
        this.replyPostId = replyPostId;
    }

    public String getReplyPartyId() {
        return replyPartyId;
    }

    public void setReplyPartyId(String replyPartyId) {
        this.replyPartyId = replyPartyId;
    }

    public String getLeaveWordsId() {
        return leaveWordsId;
    }

    public void setLeaveWordsId(String leaveWordsId) {
        this.leaveWordsId = leaveWordsId;
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
