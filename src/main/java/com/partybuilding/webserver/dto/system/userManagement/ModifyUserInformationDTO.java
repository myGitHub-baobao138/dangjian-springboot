package com.partybuilding.webserver.dto.system.userManagement;

import javax.validation.constraints.NotEmpty;

/**
 * 登录数据对象
 */

public class ModifyUserInformationDTO {
	@NotEmpty(message = "用户账号不能为空")
	private String account; // 用户账号
	@NotEmpty(message = "密码不能为空")
	private String password; // 密码
	@NotEmpty(message = "用户id不能为空")
	private String userId; // 用户id

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
