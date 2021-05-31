package com.partybuilding.webserver.dto.login;

import java.io.Serializable;
import java.util.List;

public class LoginReturnDTO implements Serializable {
    private Integer state; // 用户账号状态
    private String userId; // 用户 id
    private String userName; // 用户名称
    private String account; // 账号
    private String password; // 账号密码
    private String partyId; // 党员 id
    private List<LoginReturnOrganizationMsg> organizationMsgList; // 组织信息
    private String token; // 保存会话 sessionId

    public LoginReturnDTO() {
        this.state = 0;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public List<LoginReturnOrganizationMsg> getOrganizationMsgList() {
        return organizationMsgList;
    }

    public void setOrganizationMsgList(List<LoginReturnOrganizationMsg> organizationMsgList) {
        this.organizationMsgList = organizationMsgList;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}