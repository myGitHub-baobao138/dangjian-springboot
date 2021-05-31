package com.partybuilding.webserver.controller.login;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.login.LoginDTO;
import com.partybuilding.webserver.dto.login.LoginReturnDTO;
import com.partybuilding.webserver.service.system.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/SysLogin")
@Api(value = "登录")
public class LoginController {
    @Autowired
    SysUserService service;

    /**
     * 用户账号登录接口
     */
    @ApiOperation(value = "登录接口")
    @PostMapping("/accountLogin")
    public JsonResult userLogin(@RequestBody @Validated LoginDTO dto) {
        JsonResult jsonResult = new JsonResult();
        UsernamePasswordToken token = new UsernamePasswordToken(dto.getAccount(), dto.getPassword());
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
            Subject subject = SecurityUtils.getSubject();
            ((LoginReturnDTO) subject.getPrincipal()).setToken(subject.getSession().getId().toString());
        } catch (UnknownAccountException ua) {
            jsonResult.setMessage("登陆失败，账号不存在！");
            jsonResult.setCode(404);
        } catch (IncorrectCredentialsException ice) {
            jsonResult.setMessage("登陆失败，密码错误！");
            jsonResult.setCode(404);
        } catch (AuthenticationException ae) {
            jsonResult.setMessage("登陆失败，该账号已被禁用！");
            jsonResult.setCode(404);
        }
        if (currentUser.isAuthenticated()) {
//            SessionsSecurityManager securityManager = (SessionsSecurityManager) SecurityUtils.getSecurityManager();
//            DefaultSessionManager sessionManager = (DefaultSessionManager) securityManager.getSessionManager();
//            Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();
//            for (Session session : sessions) {
//                // 踢出先登录的用户
//                if (dto.getAccount().equals(session.getAttribute("loginedUser"))) {
//                    try {
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        System.out.println("发送信息出现异常!");
//                    }
//                    session.setTimeout(0);
//                }
//            }
            jsonResult.setMessage("登录成功!");
            jsonResult.setCode(200);
            jsonResult.setData(currentUser.getPrincipal());
        } else {
            if (jsonResult.getMessage() == null || "".equals(jsonResult.getMessage())) {
                jsonResult.setMessage("登陆失败，账号异常！");
                jsonResult.setCode(404);
            }
        }
        return jsonResult;
    }

    @ApiOperation(value = "注销登录接口")
    @GetMapping("/accountLogout")
    public void accountLogout() {
        SecurityUtils.getSubject().logout();
    }
}
