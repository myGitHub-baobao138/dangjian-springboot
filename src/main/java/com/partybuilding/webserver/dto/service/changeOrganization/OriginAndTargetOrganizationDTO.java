package com.partybuilding.webserver.dto.service.changeOrganization;

import java.util.List;

public class OriginAndTargetOrganizationDTO {
    private String originOrganizationId;
    private String originOrganizationName;
    List<OrganizationIdAndNameDTO> targetOrganizations;

    public String getOriginOrganizationId() {
        return originOrganizationId;
    }

    public void setOriginOrganizationId(String originOrganizationId) {
        this.originOrganizationId = originOrganizationId;
    }

    public String getOriginOrganizationName() {
        return originOrganizationName;
    }

    public void setOriginOrganizationName(String originOrganizationName) {
        this.originOrganizationName = originOrganizationName;
    }

    public List<OrganizationIdAndNameDTO> getTargetOrganizations() {
        return targetOrganizations;
    }

    public void setTargetOrganizations(List<OrganizationIdAndNameDTO> targetOrganizations) {
        this.targetOrganizations = targetOrganizations;
    }
}
