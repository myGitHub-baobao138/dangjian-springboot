package com.partybuilding.webserver.entity.system;

import java.util.Date;
/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 微信用户实体类
 */
public class SysWxUser {
    private String id;

    private String nickname;

    private Integer sex;

    private String name;

    private String studentJobNumber;

    private Date createTime;

    private String avatarurl;

    private Integer isAudited;

    private Date verifyTime;

    private String telNumber;

    private Integer type;

    private Integer isSecretary;

    private String partyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStudentJobNumber() {
        return studentJobNumber;
    }

    public void setStudentJobNumber(String studentJobNumber) {
        this.studentJobNumber = studentJobNumber == null ? null : studentJobNumber.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public Integer getIsAudited() {
        return isAudited;
    }

    public void setIsAudited(Integer isAudited) {
        this.isAudited = isAudited;
    }

    public Date getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }


    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber == null ? null : telNumber.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsSecretary() {
        return isSecretary;
    }

    public void setIsSecretary(Integer isSecretary) {
        this.isSecretary = isSecretary;
    }



    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }
}