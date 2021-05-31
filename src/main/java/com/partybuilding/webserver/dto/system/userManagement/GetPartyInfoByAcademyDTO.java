package com.partybuilding.webserver.dto.system.userManagement;

/**
 * 创建账号时用户信息dto
 */
public class GetPartyInfoByAcademyDTO {
    private String partyMemberId;
    private String partyMemberName;

    public String getPartyMemberId() {
        return partyMemberId;
    }

    public void setPartyMemberId(String partyMemberId) {
        this.partyMemberId = partyMemberId;
    }

    public String getPartyMemberName() {
        return partyMemberName;
    }

    public void setPartyMemberName(String partyMemberName) {
        this.partyMemberName = partyMemberName;
    }
}
