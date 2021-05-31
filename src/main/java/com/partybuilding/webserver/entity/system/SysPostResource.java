package com.partybuilding.webserver.entity.system;

public class SysPostResource {
	private String id; // 资源权限id

	private String resourceId; // 资源id

	private String postId; // 职务id

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}
}
