package com.partybuilding.webserver.dto.system.partyInformation;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AddInformationDto {
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
    //职务名称
    private String postName;
    //组织
    private String organizationName;

    public String toString(){
        return partyId+" "+name+" "+phoneNumber+" "+
                snoOrJobNumber+" "+category+" "+sex+" "+
                getEnterTime()+" "+postName+" "+organizationName;
    }

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

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}
