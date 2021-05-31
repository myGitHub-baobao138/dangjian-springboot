package com.partybuilding.webserver.dto.service.threeSessionOneClass;

import java.util.List;

public class OrganizationPartyMemberListDTO {

    /**
     * @Description 选择参会人员时的树形穿梭框所需数据
     */

    private String id;

    private String pid;

    private String label;

    private String partyId;

    private List<OrganizationPartyMemberListDTO> lowerOrganization;

    private List<OrganizationPartyMemberListDTO> partyMember;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public List<OrganizationPartyMemberListDTO> getLowerOrganization() {
        return lowerOrganization;
    }

    public void setLowerOrganization(List<OrganizationPartyMemberListDTO> lowerOrganization) {
        this.lowerOrganization = lowerOrganization;
    }

    public List<OrganizationPartyMemberListDTO> getPartyMember() {
        return partyMember;
    }

    public void setPartyMember(List<OrganizationPartyMemberListDTO> partyMember) {
        this.partyMember = partyMember;
    }
}
