package com.partybuilding.webserver.entity.system;

import java.util.List;

public class SysResource {
	private String id; // 资源id
	private String url; // 资源url
	private List<SysPost> posts; // 职务

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<SysPost> getPosts() {
		return posts;
	}

	public void setPosts(List<SysPost> posts) {
		this.posts = posts;
	}
}
