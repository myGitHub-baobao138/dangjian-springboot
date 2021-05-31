package com.partybuilding.webserver.dto;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public class UpdatePermissionInputDTO {
    private String postId;
    private String organizationId;
    private String permissionIds;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(String permissionIds) {
        this.permissionIds = permissionIds;
    }
}
