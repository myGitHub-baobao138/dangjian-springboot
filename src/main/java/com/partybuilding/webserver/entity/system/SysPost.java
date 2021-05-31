package com.partybuilding.webserver.entity.system;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SysPost {
    private String id; // 职务id

    private String name; // 职务名称

    private Integer associatedNumber; // 职务关联人数

    private String createPartyId; // 职务创建人id

    private String createPartyName; // 职务创建人姓名

    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    private Date createTime; // 职务创建时间

    private Integer postRank; // 职务等级

    public SysPost() {
        this.name = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAssociatedNumber() {
        return associatedNumber;
    }

    public void setAssociatedNumber(Integer associatedNumber) {
        this.associatedNumber = associatedNumber;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatePartyId() {
        return createPartyId;
    }

    public void setCreatePartyId(String createPartyId) {
        this.createPartyId = createPartyId;
    }

    public String getCreatePartyName() {
        return createPartyName;
    }

    public void setCreatePartyName(String createPartyName) {
        this.createPartyName = createPartyName;
    }

    public Integer getPostRank() {
        return postRank;
    }

    public void setPostRank(Integer postRank) {
        this.postRank = postRank;
    }
}