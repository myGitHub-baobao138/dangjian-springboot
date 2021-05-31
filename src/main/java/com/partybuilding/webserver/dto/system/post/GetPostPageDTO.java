package com.partybuilding.webserver.dto.system.post;

import javax.validation.constraints.NotNull;

/**
 * 登录数据对象
 */

public class GetPostPageDTO {
	/**
	 * 职务名称
	 */
	private String postName;
	/**
	 * 当前页
	 */
	@NotNull(message = "当前页数不能为空")
	private Integer currentPage;

	/**
	 * 每页数量
	 */
	@NotNull(message = "每页数量不能为空")
	private Integer pageSize;

	public GetPostPageDTO() {
		this.postName = "";
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
