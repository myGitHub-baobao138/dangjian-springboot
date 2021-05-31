package com.partybuilding.webserver.dto.system.partyInformation;
//院校管理员查询
public class SearchByNameAndAcademy {
    String academyId;
    String name;

    public String getAcademy() {
        return academyId;
    }

    public void setAcademy(String academy) {
        this.academyId = academy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
