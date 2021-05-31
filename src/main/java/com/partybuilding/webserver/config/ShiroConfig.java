package com.partybuilding.webserver.config;

import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.*;

/**
 *
 */
@Configuration
public class ShiroConfig {
    /**
     * 配置Shiro的web过滤器，拦截浏览器请求，并交给securityManager处理
     *
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean webFilter() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager());

        // 配置拦截链 使用LinkedHashpMap，因为LinkedHashMap是有序的，shiro会根据添加的顺序进行拦截
        // Map<K,V> K指的是拦截的url V值是指该url是否拦截
        Map<String, String> filterChainMap = new LinkedHashMap<>(16);

        // autic:所有url必须认证通过才可以访问；
        // anon：所有url都可以匿名访问，
        // 先配置anon 在配置 authc
        filterChainMap.put("/SysLogin/accountLogin", "anon");
        filterChainMap.put("/System/RightController/403", "anon");
        filterChainMap.put("/System/RightController/changeUserRole/**", "anon");
        filterChainMap.put("/System/SysPermission/**", "anon");
        filterChainMap.put("/SysLogin/accountLogout/**", "anon");

//        filterChainMap.put("/**","authc");
        // 设置拦截器请求后跳转的URL
        shiroFilterFactoryBean.setLoginUrl("/System/RightController/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 配置Shiro核心 安全管理器 SecurityManager
     * SecurityManager安全管理器：所有与安全有关的操作都会与SecurityManager交互；
     * 且它管理着所有Subject；负责与后边介绍的其他组件进行交互。
     * （类似于SpringMVC中的DispatcherServlet控制器）
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        ShiroRealm shiroRealm = shiroRealm();
        securityManager.setAuthenticator(authenticator(shiroRealm));
        securityManager.setAuthorizer(authorizer(shiroRealm));
        securityManager.setRealm(shiroRealm);
        securityManager.setSessionManager(new ShiroWebSessionManager());
        return securityManager;
    }

    @Bean
    ShiroRealm shiroRealm() {
        return new ShiroRealm();
    }

    /**
     * 开启aop注解支持
     * 即在controller中使用 @RequiresPermissions("user/userList")
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        // 设置安全管理器
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    /**
     * 处理未授权的异常，返回自定义的错误页面（403）
     *
     * @return
     */
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.setProperty("UnauthorizedException", "403.html");
        resolver.setExceptionMappings(properties);
        return resolver;
    }

    /**
     * Shiro生命周期处理器
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @ConditionalOnMissingBean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public Authorizer authorizer(ShiroRealm myRealm) {
        ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();
        Collection<Realm> crealms = new ArrayList<>();
        crealms.add(myRealm);
        authorizer.setRealms(crealms);
        return authorizer;
    }

    @Bean
    public Authenticator authenticator(ShiroRealm myRealm) {
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        Collection<Realm> crealms = new ArrayList<>();
        crealms.add(myRealm);
        authenticator.setRealms(crealms);
        return authenticator;
    }
}
