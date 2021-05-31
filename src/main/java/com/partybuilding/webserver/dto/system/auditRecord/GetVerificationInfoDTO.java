package com.partybuilding.webserver.dto.system.auditRecord;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public class GetVerificationInfoDTO {
    /**
     * 微信用户id
     */
    private String id;

    /**
     * 职务id
     */

    private String pId;

    /**
     * 组织id
     */
    private String ogId;

    /**
     * 微信昵称
     */
    private String nickname;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别 0-男 1-女
     */
    private Integer sex;

    /**
     * 学/工号
     */
    private String studentJobNumber;

    /**
     * 组织名
     */
    private List<String> organizationName;

    /**
     * 电话号码（联系方式）
     */
    private String telNumber;

    /**
     * 类别 0-学生 1-教师
     */
    private Integer type;


    /**
     * 职务
     */
    private List<String> position;



    /**
     * 审核记录
     */
    private List<VerificationRecordDTO> auditRecords;

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getOgId() {
        return ogId;
    }

    public void setOgId(String ogId) {
        this.ogId = ogId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getStudentJobNumber() {
        return studentJobNumber;
    }

    public void setStudentJobNumber(String studentJobNumber) {
        this.studentJobNumber = studentJobNumber;
    }



    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<String> getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(List<String> organizationName) {
        this.organizationName = organizationName;
    }

    public List<String> getPosition() {
        return position;
    }

    public void setPosition(List<String> position) {
        this.position = position;
    }

    public List<VerificationRecordDTO> getAuditRecords() {
        return auditRecords;
    }

    public void setAuditRecords(List<VerificationRecordDTO> auditRecords) {
        this.auditRecords = auditRecords;
    }
}
