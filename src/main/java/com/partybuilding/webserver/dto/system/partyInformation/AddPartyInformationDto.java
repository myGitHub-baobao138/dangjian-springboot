package com.partybuilding.webserver.dto.system.partyInformation;

public class AddPartyInformationDto {
    //党员id
    private String partyId;
    //党员姓名
    private String name;
    //党员电话号码
    private String phoneNumber;
    //党员学号或者工号
    private String snoOrJobNumber;
    //类别，教师或者学生
    private String category;
    //性别
    private int sex;
    //入党时间
    private String enterTime;

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSnoOrJobNumber() {
        return snoOrJobNumber;
    }

    public void setSnoOrJobNumber(String snoOrJobNumber) {
        this.snoOrJobNumber = snoOrJobNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }
}
