package com.partybuilding.webserver.dto.login;

public class LoginReturnOrganizationMsg {
    private String organizationName; // 组织名称
    private String organizationId; // 组织 id
    private String organizationRank; // 组织等级
    private String postId; // 职务 id
    private String postName; // 职务名称

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationRank() {
        return organizationRank;
    }

    public void setOrganizationRank(String organizationRank) {
        this.organizationRank = organizationRank;
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
}
