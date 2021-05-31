package com.partybuilding.webserver.dto.system.right.allocateRight;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.partybuilding.webserver.dto.system.right.createRight.RightsDTO;
import com.partybuilding.webserver.dto.system.right.showRight.ResourceColumn;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class AllocateRightRequest {
    private String organizationId; // 组织 id
    private String postId; // 职务 id
    private Object rightInfo; // 权限字符串
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String roleId; // 角色id

    // 转换后的权限列表
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<RightsDTO> rightsDTOList;

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

    public Object getRightInfo() {
        return rightInfo;
    }

    public void setRightInfo(String rightInfo) {
        this.rightInfo = rightInfo;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<RightsDTO> getRightsDTOList() {
        return rightsDTOList;
    }

    public void setRightsDTOList(List<RightsDTO> rightsDTOList) {
        this.rightsDTOList = rightsDTOList;
    }
}
