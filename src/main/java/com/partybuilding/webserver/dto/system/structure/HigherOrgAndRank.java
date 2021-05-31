package com.partybuilding.webserver.dto.system.structure;

public class HigherOrgAndRank {
    String organizationId;
    Integer partyOrganizationRank;
    Integer rank;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getPartyOrganizationRank() {
        return partyOrganizationRank;
    }

    public void setPartyOrganizationRank(Integer partyOrganizationRank) {
        this.partyOrganizationRank = partyOrganizationRank;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
