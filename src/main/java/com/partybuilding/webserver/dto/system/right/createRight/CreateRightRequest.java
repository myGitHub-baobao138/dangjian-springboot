package com.partybuilding.webserver.dto.system.right.createRight;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.partybuilding.webserver.dto.system.right.showRight.ResourceColumn;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class CreateRightRequest {
    private String organizationId; // 组织 id
    private String postId; // 职务 id
    private String partyId; // 创建党员 id
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String roleId; // 角色id
    @JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Date createTime; // 创建时间

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
