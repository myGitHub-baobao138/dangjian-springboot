package com.partybuilding.webserver.dto.role;

import javax.validation.constraints.NotEmpty;

public class UserRoleDTO {
    @NotEmpty(message = "组织id不能为空")
    private String organizationId; // 组织 id
    @NotEmpty(message = "职务id不能为空")
    private String postId; // 职务 id

    public UserRoleDTO(@NotEmpty(message = "组织id不能为空") String organizationId, @NotEmpty(message = "职务id不能为空") String postId) {
        this.organizationId = organizationId;
        this.postId = postId;
    }
    public UserRoleDTO(){

    }

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
}
