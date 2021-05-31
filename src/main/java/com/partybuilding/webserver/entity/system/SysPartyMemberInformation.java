package com.partybuilding.webserver.entity.system;

import java.util.Date;

public class SysPartyMemberInformation {
    private String id;

    private String snoOrJobNumber;

    private String name;

    private String postId;

    private Boolean sex;

    private Date partyJoinTime;

    private String academyId;

    private String contact;

    private String classification;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSnoOrJobNumber() {
        return snoOrJobNumber;
    }

    public void setSnoOrJobNumber(String snoOrJobNumber) {
        this.snoOrJobNumber = snoOrJobNumber == null ? null : snoOrJobNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId == null ? null : postId.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getPartyJoinTime() {
        return partyJoinTime;
    }

    public void setPartyJoinTime(Date partyJoinTime) {
        this.partyJoinTime = partyJoinTime;
    }

    public String getAcademyId() {
        return academyId;
    }

    public void setAcademyId(String academyId) {
        this.academyId = academyId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification == null ? null : classification.trim();
    }
}