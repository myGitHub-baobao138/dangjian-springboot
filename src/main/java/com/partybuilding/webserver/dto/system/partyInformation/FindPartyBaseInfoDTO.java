package com.partybuilding.webserver.dto.system.partyInformation;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FindPartyBaseInfoDTO {
    private String partyId; // 党员id
    private String postName; // 职务名称
    private String name; // 党员名称
    private String number; // 学号或工号
    private String partyJoinTime; // 党员加入时间
    private String organizationName; // 组织名称
    private String contact; // 联系方式i
    private Integer classification; // 类别（0 学生 1 教师）
    private String spopId; // 中间关系表 id
    private Integer sex;
    private String organizationId;
    private String postId;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPartyJoinTime() {
        return partyJoinTime;
    }

    public void setPartyJoinTime(String partyJoinTime) {
        this.partyJoinTime = partyJoinTime;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }

    public String getSpopId() {
        return spopId;
    }

    public void setSpopId(String spopId) {
        this.spopId = spopId;
    }
}
