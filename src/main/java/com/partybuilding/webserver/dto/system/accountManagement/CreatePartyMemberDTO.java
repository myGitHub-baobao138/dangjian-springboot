package com.partybuilding.webserver.dto.system.accountManagement;

/**
 * 当前组织下的党员数据对象
 */
public class CreatePartyMemberDTO {
	private String id; // 学号或工号
	private String name;// 姓名

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
