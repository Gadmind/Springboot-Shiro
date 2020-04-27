package com.daop.security.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.shiro.conf
 * @Description: 用户权限信息验证
 * @DATE: 2020-04-27 22:10
 * @AUTHOR: Daop
 **/
public class UserRealm extends AuthorizingRealm {
    Logger logger = LoggerFactory.getLogger(UserRealm.class);

    /**
     * 授权信息
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("=====用户授权=====");
        return null;
    }

    /**
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("====用户权限认证===");
        String name = "root";
        String password = "123456";
        UsernamePasswordToken authenticationToken = (UsernamePasswordToken) token;
        if (!authenticationToken.getUsername().equals(name)){
            return null;
        }
            return new SimpleAuthenticationInfo("",password,"");
    }
}
