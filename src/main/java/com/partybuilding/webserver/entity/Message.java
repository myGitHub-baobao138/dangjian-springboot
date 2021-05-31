package com.partybuilding.webserver.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Message)实体类
 *
 */
public class Message implements Serializable {
    private static final long serialVersionUID = -42432858214582378L;
    /**
    * 消息表的id
    */
    private String id;
    /**
    * 消息的标题
    */
    private String messageTitle;
    /**
    * 消息内容
    */
    private String messageContent;
    /**
    * 1 一对一的消息或者1对多的消息，2是会议纪要发送的消息，3是会议纪要上传的消息
    */
    private String messageType;
    /**
    * 会议id，包括会议纪要提醒以及会议纪要上传
    */
    private String meetingId;
    /**
    * 消息发布时间
    */
    private Date messagePublishTime;
    /**
    * 消息发布人的id
    */
    private String partyId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public Date getMessagePublishTime() {
        return messagePublishTime;
    }

    public void setMessagePublishTime(Date messagePublishTime) {
        this.messagePublishTime = messagePublishTime;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

}