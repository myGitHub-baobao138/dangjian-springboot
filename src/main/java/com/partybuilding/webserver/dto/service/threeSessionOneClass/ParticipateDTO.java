package com.partybuilding.webserver.dto.service.threeSessionOneClass;

import javax.validation.constraints.NotNull;

public class ParticipateDTO {

    private String id;//文章id

    @NotNull(message = "管理员是否校级不能为空")
    private Boolean isSchool;

    private String schoolOrCollege;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsSchool() {
        return isSchool;
    }

    public void setIsSchool(Boolean school) {
        isSchool = school;
    }

    public String getSchoolOrCollege() {
        return schoolOrCollege;
    }

    public void setSchoolOrCollege(String schoolOrCollege) {
        this.schoolOrCollege = schoolOrCollege;
    }
}
