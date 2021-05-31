package com.partybuilding.webserver.dto.system.academy;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 编辑学院信息数据类
 */
public class UpdateAcademyDTO {
    @NotNull(message = "id不能为空")
    private String id;

    @NotNull(message = "学院名不能为空")
    private String academyName;

    @NotNull(message = "校区不能为空")
    private String campus;

    @NotNull(message = "学校名不能为空")
    private String schoolName;

    private Integer isSchool;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName == null ? null : academyName.trim();
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus == null ? null : campus.trim();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public Integer getIsSchool() {
        return isSchool;
    }

    public void setIsSchool(Integer isSchool) {
        this.isSchool = isSchool;
    }
}
