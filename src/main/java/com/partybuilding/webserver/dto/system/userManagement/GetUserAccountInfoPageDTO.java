package com.partybuilding.webserver.dto.system.userManagement;

import javax.validation.constraints.NotNull;

/**
 * 登录数据对象
 */

public class GetUserAccountInfoPageDTO {
	/**
	 * 用户名称
	 */
	private String name;
	/**
	 * 组织Id
	 */
	private String organizationId;
	/**
	 * 组织等级
	 */
	@NotNull
	private Integer organizationRank;
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

	public GetUserAccountInfoPageDTO() {
		this.name = "";
	}

	public Integer getOrganizationRank() {
		return organizationRank;
	}

	public void setOrganizationRank(Integer organizationRank) {
		this.organizationRank = organizationRank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
}
