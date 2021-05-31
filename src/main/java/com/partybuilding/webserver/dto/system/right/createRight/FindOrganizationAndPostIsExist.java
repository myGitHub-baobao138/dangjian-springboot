package com.partybuilding.webserver.dto.system.right.createRight;

public class FindOrganizationAndPostIsExist {
    private String organizationId; // 组织 id
    private String postId; // 职务 id

    public FindOrganizationAndPostIsExist(String organizationId, String postId) {
        this.organizationId = organizationId;
        this.postId = postId;
    }

    public FindOrganizationAndPostIsExist() {
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
