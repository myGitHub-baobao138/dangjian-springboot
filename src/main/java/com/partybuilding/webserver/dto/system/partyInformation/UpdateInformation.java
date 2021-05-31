package com.partybuilding.webserver.dto.system.partyInformation;

/**
 * 修改党员信息dto
 */
public class UpdateInformation {
    //postId 职务id
    private String postId;

    private String postName;
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

    //组织id
    private String organizationId;

    //党员当前组织职务id，在党员的组织职务表里面
    private String partyOrgPOstId;

    public String getPartyOrgPOstId() {
        return partyOrgPOstId;
    }

    public void setPartyOrgPOstId(String partyOrgPOstId) {
        this.partyOrgPOstId = partyOrgPOstId;
    }

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
}
