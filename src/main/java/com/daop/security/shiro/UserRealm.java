package com.daop.security.shiro;

import com.daop.security.entity.SysUser;
import com.daop.security.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
    SysUserService userService;
    /**
     * 授权信息
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("========================================用户权限认证========================================");
        String name = (String) principals.getPrimaryPrincipal();
        SysUser sysUser = userService.getSysUserByUserName(name);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        sysUser.getRoles().forEach((role) -> {
            simpleAuthorizationInfo.addRole(role.getRoletype());
            role.getPermissions().forEach((permission) -> {
                simpleAuthorizationInfo.addStringPermission(permission.getPermissionname());
            });
        });
        System.out.println(simpleAuthorizationInfo.getRoles());
        System.out.println(simpleAuthorizationInfo.getStringPermissions());
        return simpleAuthorizationInfo;
    }

    /**
     * @param token 权限令牌
     * @return 简单的认证信息
     * @throws AuthenticationException 认证失败
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("========================================用户授权认证========================================");
        if (null == token.getPrincipal()) {
            return null;
        }
        //获取到用户名
        String principal = token.getPrincipal().toString();
        //同数据库做比对
        SysUser sysUser = userService.getSysUserByUserName(principal);

        if (!principal.equals(sysUser.getUsername())) {
            return null;
        }
        return new SimpleAuthenticationInfo(principal, sysUser.getPassword(), getName());
    }
}
