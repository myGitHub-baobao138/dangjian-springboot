package com.partybuilding.webserver.dto.service.changeOrganization;

public class FindPartyIsExistOnOriginOrganizationDTO {
    private String number; // 学号或工号
    private String organizationName; // 组织名称

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}
