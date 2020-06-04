package com.daop.security.shiro;

import com.daop.security.customexception.DefinitionException;
import com.daop.security.entity.SysUser;
import com.daop.security.service.LoginService;
import com.daop.security.service.SysPermissionService;
import com.daop.security.service.SysRoleService;
import com.daop.security.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.shiro.conf
 * @Description: 用户权限信息验证
 * @DATE: 2020-04-27 22:10
 * @AUTHOR: Daop
 **/

public class UserRealm extends AuthorizingRealm {
    Logger logger = LoggerFactory.getLogger(UserRealm.class);
    @Autowired
    private LoginService loginService;
    @Autowired
    private SysRoleService roleService;
    @Autowired
    private SysPermissionService permissionService;

    /**
     * 授权信息
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("========================================用户权限认证========================================");
        Object principal = SecurityUtils.getSubject().getPrincipal();
        SysUser sysUser = null;
        if (principal != null) {
            sysUser = new SysUser();
            BeanUtils.copyProperties(principal, sysUser);
        }
        //角色列表
        Set<String> roles = new HashSet<String>(1);
        //权限列表
        Set<String> permissions = new HashSet<String>(1);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //管理员及超级管理员拥有所有权限
        if (sysUser.getId().equals("1")) {
            simpleAuthorizationInfo.addRole("root");
            simpleAuthorizationInfo.addStringPermission("*:*:*");
        }else if (sysUser.getId().equals("2")) {
            simpleAuthorizationInfo.addRole("admin");
            simpleAuthorizationInfo.addStringPermission("*:*:*");
        } else {
            roles = roleService.listRoleKeys(sysUser.getId());
            permissions = permissionService.listPermissionsByUserId(sysUser.getId());
            simpleAuthorizationInfo.setRoles(roles);
            simpleAuthorizationInfo.setStringPermissions(permissions);
            System.out.println(roles);
            System.out.println(permissions);
        }

        return simpleAuthorizationInfo;
    }

    /**
     * @param token 登录认证
     * @return 简单的认证信息
     * @throws AuthenticationException 认证失败
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("========================================用户授权认证========================================");
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        String password = "";
        if (upToken.getPassword() != null) {
            password = new String(upToken.getPassword());
        }
        SysUser user = null;
        try {
            user = loginService.login(username, password);
        } catch (Exception e) {
            throw new DefinitionException(500, "用户名或密码错误");
        }

        return new SimpleAuthenticationInfo(user, password, getName());
    }
}
