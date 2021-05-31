package com.partybuilding.webserver.entity.message;

import java.io.Serializable;
import java.util.List;

/**
 * @description
 */
public class MessageDTO implements Serializable {
    //消息id
    private String id;
    //消息类型
    private String messageType;
    //消息内容
    private String messageContent;
    //消息的标题
    private String messageTitle;
    //消息的会议id
    private String meetingId;
    //发布人的id
    private String partyId;


    //消息接收对象的id，党员id
    private List<String> messageObjects;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public List<String> getMessageObjects() {
        return messageObjects;
    }

    public void setMessageObjects(List<String> messageObjects) {
        this.messageObjects = messageObjects;
    }
}
