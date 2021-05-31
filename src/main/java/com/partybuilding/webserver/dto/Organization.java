package com.partybuilding.webserver.dto;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public class Organization {

    private String organizationId;

    //组织名称
    private String organizationName;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}
