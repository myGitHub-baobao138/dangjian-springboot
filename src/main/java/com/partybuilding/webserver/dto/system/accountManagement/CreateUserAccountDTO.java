package com.partybuilding.webserver.dto.system.accountManagement;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 创建账户数据对象
 */
public class CreateUserAccountDTO {
	@NotNull
	private String id; // 用户id

	@Length(min = 6,max = 30,message = "账号长度必须在6-30位之间")
	@NotEmpty(message = "账号不能为空")
	private String account; // 账号

	@NotEmpty(message = "密码不能为空")
	private String password; // 密码

	@NotEmpty(message = "党员id不能为空")
	private String sysPartyMemberInformationId; // 党员id

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getSysPartyMemberInformationId() {
		return sysPartyMemberInformationId;
	}

	public void setSysPartyMemberInformationId(String sysPartyMemberInformationId) {
		this.sysPartyMemberInformationId = sysPartyMemberInformationId;
	}
}
