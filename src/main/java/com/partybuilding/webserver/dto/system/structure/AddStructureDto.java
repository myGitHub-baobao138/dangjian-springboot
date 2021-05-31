package com.partybuilding.webserver.dto.system.structure;

public class AddStructureDto {
    //组织名称
    private String organizationName;
    //上级组织id
    private String higherOrganizationId;
    //  备注说明
    private String remark;
    //组织等级
    private int rank;
    //创建者的党员id，来自管理员表
    private String createMemberId;


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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateMemberId() {
        return createMemberId;
    }

    public void setCreateMemberId(String createMemberId) {
        this.createMemberId = createMemberId;
    }
}
