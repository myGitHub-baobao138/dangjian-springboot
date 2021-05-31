package com.partybuilding.webserver.dto.system.userManagement;

/**
 * 用户账号信息
 */
public class GetUserAccountInfoDTO {
	private String userId;// 用户账户id
	private String informationId;// 党员信息id
	private String account;// 账号
	private String password;// 密码
	private String name;// 姓名
	private String organizationName; // 组织名称
	private String postName; // 职务名称
	private String classification;// 类别 0 学生 1 教师
	private Boolean isEnable;// 是否启用 0 禁用 1 启用

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getInformationId() {
		return informationId;
	}

	public void setInformationId(String informationId) {
		this.informationId = informationId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public Boolean getEnable() {
		return isEnable;
	}

	public void setEnable(Boolean enable) {
		isEnable = enable;
	}
}
