package com.partybuilding.webserver.dto.system.right;

import javax.validation.constraints.NotEmpty;

/**
 * 删除权限角色及资源请求对象
 */
public class DeleteRightRoleAndResourceDTO {
    @NotEmpty(message = "组织id不能为空")
    private String organizationId; // 组织 id
    @NotEmpty(message = "职务id不能为空")
    private String postId; // 职务 id

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
