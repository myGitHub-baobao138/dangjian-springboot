package com.partybuilding.webserver.dto.service.volunteer;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 查看活动报名详情
 */
public class SelectRegistrationDetailsDTO {
    /**
     * 报名时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm",timezone = "GMT+8")
    private Date registrationTime;

    /**
     * 报名人姓名
     */
    private String name;

    /**
     * 报名人身份
     */
    private String registerIdentity;

    /**
     * 联系方式
     */
    private String contactNumber;


    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterIdentity() {
        return registerIdentity;
    }

    public void setRegisterIdentity(String registerIdentity) {
        this.registerIdentity = registerIdentity;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }


}
