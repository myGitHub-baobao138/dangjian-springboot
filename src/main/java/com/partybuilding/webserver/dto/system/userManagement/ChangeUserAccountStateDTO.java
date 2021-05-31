package com.partybuilding.webserver.dto.system.userManagement;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 登录数据对象
 */
public class ChangeUserAccountStateDTO {
	@NotNull(message = "状态不能为空!")
	private Boolean state; // 0 禁用 1启用
	@NotEmpty(message = "用户id不能为空")
	private String userId; // 账号

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
