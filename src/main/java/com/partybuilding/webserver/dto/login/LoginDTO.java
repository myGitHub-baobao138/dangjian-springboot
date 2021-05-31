package com.partybuilding.webserver.dto.login;

import org.hibernate.validator.constraints.Length;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;

/**
 * 登录数据对象
 */
public class LoginDTO {
    @Length(min = 6, max = 30, message = "账号必须在6-30位之间")
    @NotEmpty(message = "账号不能为空")
    private String account;// 账号

    @Length(min = 6, max = 30, message = "密码必须在6-30位之间")
    @NotEmpty(message = "密码不能为空")
    private String password; // 密码

    public LoginDTO(
            @Length(min = 6, max = 30, message = "账号必须在6-30位之间")
            @NotEmpty(message = "账号不能为空") String account,
            @Length(min = 6, max = 30, message = "密码必须在6-30位之间")
            @NotEmpty(message = "密码不能为空") String password) {
        this.account = account;
        this.password = password;
    }
    public LoginDTO(){

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
}
