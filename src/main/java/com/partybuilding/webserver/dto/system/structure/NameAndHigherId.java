package com.partybuilding.webserver.dto.system.structure;

/**
 * @description
 */
public class NameAndHigherId {
    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getHigherOrganizationId() {
        return higherOrganizationId;
    }

    public void setHigherOrganizationId(String higherOrganizationId) {
        this.higherOrganizationId = higherOrganizationId;
    }

    private String organizationName;
    private String higherOrganizationId;

}
