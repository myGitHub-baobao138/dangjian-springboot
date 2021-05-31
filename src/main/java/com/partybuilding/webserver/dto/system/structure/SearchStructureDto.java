package com.partybuilding.webserver.dto.system.structure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class SearchStructureDto {
    //组织id
    private String id;

    private String organizationName;
    //高一级职务
//    private String higherOrganizationName;
    //说明
    private String remark;
    //关联人数
    private int amount;
    //等级
    private int rank;

    private String createMemberId;
    //下一等级的数据
//    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler" })
    List<SearchStructureDto> children;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

//    public String getHigherOrganizationName() {
//        return higherOrganizationName;
//    }
//
//    public void setHigherOrganizationName(String higherOrganizationName) {
//        this.higherOrganizationName = higherOrganizationName;
//    }

    public String getCreateMemberId() {
        return createMemberId;
    }

    public void setCreateMemberId(String createMemberId) {
        this.createMemberId = createMemberId;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public List<SearchStructureDto> getChildren() {
        return children;
    }

    public void setChildren(List<SearchStructureDto> children) {
        this.children = children;
    }
}
