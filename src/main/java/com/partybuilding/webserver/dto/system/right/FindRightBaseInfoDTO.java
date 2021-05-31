package com.partybuilding.webserver.dto.system.right;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 查找权限管理基本信息对象
 */
public class FindRightBaseInfoDTO {
    private String organizationId; // 组织 id
    private String getOrganizationName; // 组织名称
    private String postId; // 职务 id
    private String postName; // 职务名称
    private String createPartyName; // 创建人员姓名
    private String rightColumns; // 拥有权限的栏目
    @JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss",timezone = "GMT+8")
    private Date createTime; // 创建时间

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getGetOrganizationName() {
        return getOrganizationName;
    }

    public void setGetOrganizationName(String getOrganizationName) {
        this.getOrganizationName = getOrganizationName;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getCreatePartyName() {
        return createPartyName;
    }

    public void setCreatePartyName(String createPartyName) {
        this.createPartyName = createPartyName;
    }

    public String getRightColumns() {
        return rightColumns;
    }

    public void setRightColumns(String rightColumns) {
        this.rightColumns = rightColumns;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
