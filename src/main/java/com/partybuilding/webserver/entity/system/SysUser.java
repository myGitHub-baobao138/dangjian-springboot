package com.partybuilding.webserver.entity.system;

import java.io.Serializable;
import java.util.List;

/**
 * 用户表
 */
public class SysUser implements Serializable {
    private String id; // 用户id
    private String account; // 账号
    private String password; // 密码
    private String sysPartyMemberInformationId; // 党员id
    private Boolean isEnabled; // 是否启用

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSysPartyMemberInformationId() {
        return sysPartyMemberInformationId;
    }

    public void setSysPartyMemberInformationId(String sysPartyMemberInformationId) {
        this.sysPartyMemberInformationId = sysPartyMemberInformationId == null ? null : sysPartyMemberInformationId.trim();
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public String getPassword() {
        return password;
    }
}
