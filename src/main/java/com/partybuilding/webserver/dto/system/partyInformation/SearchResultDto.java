package com.partybuilding.webserver.dto.system.partyInformation;

public class SearchResultDto {
    //党员id
    private String id;
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
    //职务
    private String duty;
    //院校
    private String academy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }
}
