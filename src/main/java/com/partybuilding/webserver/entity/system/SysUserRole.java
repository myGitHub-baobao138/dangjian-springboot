package com.partybuilding.webserver.entity.system;

public class SysUserRole {
	private String id; // 用户角色id
	private String userId; // 用户id
	private String postId;//职务id

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}
}
