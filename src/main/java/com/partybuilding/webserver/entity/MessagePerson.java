package com.partybuilding.webserver.entity;

import java.io.Serializable;

/**
 * (MessagePerson)实体类
 *
 */
public class MessagePerson implements Serializable {
    private static final long serialVersionUID = 140089500745068934L;
    /**
    * id
    */
    private String id;
    /**
    * 消息id，来自message表
    */
    private String messageId;
    /**
    * 接受提醒的人的id，党员表里面的id
    */
    private String partyId;
    /**
    * 消息是否已读
    */
    private Integer read=0;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }

}