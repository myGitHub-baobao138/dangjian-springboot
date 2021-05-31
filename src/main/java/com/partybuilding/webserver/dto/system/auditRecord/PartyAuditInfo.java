package com.partybuilding.webserver.dto.system.auditRecord;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 党员表的信息，取出与小程序用户对比
 */
public class PartyAuditInfo {
    // 党员id
    private String id;

    private Integer sex;

    private String name;

    private String studentJobNumber;

    private String academyId;

    private String telNumber;

    private Integer type;

    private String positionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        this.name = name;
    }

    public String getStudentJobNumber() {
        return studentJobNumber;
    }

    public void setStudentJobNumber(String studentJobNumber) {
        this.studentJobNumber = studentJobNumber;
    }

    public String getAcademyId() {
        return academyId;
    }

    public void setAcademyId(String academyId) {
        this.academyId = academyId;
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

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }
}
