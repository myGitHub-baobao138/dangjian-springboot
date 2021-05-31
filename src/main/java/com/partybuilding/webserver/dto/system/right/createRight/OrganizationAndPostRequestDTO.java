package com.partybuilding.webserver.dto.system.right.createRight;

public class OrganizationAndPostRequestDTO {
    private String organizationName; // 组织名称
    private String postName; // 职务名称
    private String organizationRank;

    public String getOrganizationRank() {
        return organizationRank;
    }

    public void setOrganizationRank(String organizationRank) {
        this.organizationRank = organizationRank;
    }

    public OrganizationAndPostRequestDTO() {
        this.organizationName = "";
        this.postName = "";
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }
}
