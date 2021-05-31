package com.partybuilding.webserver.config;

import com.partybuilding.webserver.dao.system.SysRightMapper;
import com.partybuilding.webserver.dao.system.SysUserMapper;
import com.partybuilding.webserver.dto.login.LoginReturnDTO;
import com.partybuilding.webserver.dto.login.LoginReturnOrganizationMsg;
import com.partybuilding.webserver.dto.role.RouterRoleDTO;
import com.partybuilding.webserver.dto.role.UserRoleDTO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    SysUserMapper userMapper;
    @Autowired
    SysRightMapper rightMapper;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取当前用户的登录
        LoginReturnDTO userMsg = (LoginReturnDTO) principalCollection.getPrimaryPrincipal();
        // 通过simpleAuthenticationInfo做授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        List<String> pemissions = new ArrayList<>();
        List<LoginReturnOrganizationMsg> organizationMsgList = userMsg.getOrganizationMsgList();
        if (organizationMsgList != null && !organizationMsgList.isEmpty()) {
            if (organizationMsgList.get(0).getOrganizationId() != null
                    && organizationMsgList.get(0).getPostId() != null
                    && !"".equals(organizationMsgList.get(0).getOrganizationId())
                    && !"".equals(organizationMsgList.get(0).getPostId())) {
                for (LoginReturnOrganizationMsg organizationMsg : organizationMsgList) {
                    String organizationId = organizationMsg.getOrganizationId();
                    String postId = organizationMsg.getPostId();
                    // 如果当前职务下多组织进行拆分
                    String[] postIds = postId.split(",");
                    for (int i = 0; i < postIds.length; i++) {
                        List<RouterRoleDTO> routerRoleDTOS = rightMapper.findUserRight(new UserRoleDTO(organizationId, postIds[i]));
                        if (routerRoleDTOS != null && !routerRoleDTOS.isEmpty()) {
                            // 添加角色
                            simpleAuthorizationInfo.addRole(routerRoleDTOS.get(0).getRole());
                            // 获取权限
                            for (RouterRoleDTO roleDTO : routerRoleDTOS) {
                                if (!pemissions.contains(roleDTO.getRouter())) {
                                    pemissions.add(roleDTO.getRouter());
                                }
                            }
                        }
                    }
                }
            }
        }
        // 添加权限
        if (!pemissions.isEmpty()) {
            simpleAuthorizationInfo.addStringPermissions(pemissions);
        } else {
            simpleAuthorizationInfo.addStringPermission("/");
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1.获取用户输入的账号,密码
        String username = (String) authenticationToken.getPrincipal();
        String password = (String) authenticationToken.getPrincipal();
        // 2.通过username从数据库中查找到用户信息
        LoginReturnDTO userMsg = userMapper.accountLogin(username);

        // 账号不存在或密码错误的异常
        if (userMsg == null) {
            throw new UnknownAccountException("登陆失败，账号不存在！");
        }

        if (!userMsg.getPassword().equals(password)) {
            throw new IncorrectCredentialsException("登陆失败，密码错误！");
        }
        // 3.通过SimpleAuthenticationInfo做身份处理
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                userMsg, userMsg.getPassword(), getName()
        );

        // 4.用户账号状态验证等其他业务操作
        if (userMsg.getState() == 0) {
            throw new AuthenticationException("登陆失败，该账号已被禁用！");
        }
        // 5.返回身份处理对象
        return simpleAuthenticationInfo;
    }
}
