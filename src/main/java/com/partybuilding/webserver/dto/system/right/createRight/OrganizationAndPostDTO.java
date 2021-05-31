package com.partybuilding.webserver.dto.system.right.createRight;

import java.util.List;

public class OrganizationAndPostDTO {
    private String organizationId; // 组织id
    private String organizationName; // 组织名称
    private List<PostDTO> posts; // 职务

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }
}

class PostDTO {
    private String postId; // 职务id
    private String postName; // 职务名称

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
