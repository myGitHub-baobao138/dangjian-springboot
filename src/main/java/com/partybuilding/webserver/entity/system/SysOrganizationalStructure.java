package com.partybuilding.webserver.entity.system;

public class SysOrganizationalStructure {

    private String organizationId;


    private String higherOrganizationId;

    private String remark;

    private Integer rank;

    private String createMemberId;

    //组织名称
    private String organizationName;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getHigherOrganizationId() {
        return higherOrganizationId;
    }

    public void setHigherOrganizationId(String higherOrganizationId) {
        this.higherOrganizationId = higherOrganizationId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remake) {
        this.remark = remake == null ? null : remake.trim();
    }



    public String getCreateMemberId() {
        return createMemberId;
    }

    public void setCreateMemberId(String createMemberId) {
        this.createMemberId = createMemberId == null ? null : createMemberId.trim();
    }
}