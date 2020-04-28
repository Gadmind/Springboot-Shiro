package com.daop.security.shiro;

import com.daop.security.entity.SysUser;
import com.daop.security.mapper.SysUserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.provider.MD5;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.shiro.conf
 * @Description: 用户权限信息验证
 * @DATE: 2020-04-27 22:10
 * @AUTHOR: Daop
 **/

public class UserRealm extends AuthorizingRealm {
    @Autowired
    SysUserMapper userMapper;
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

        UsernamePasswordToken authenticationToken = (UsernamePasswordToken) token;
        SysUser sysUser = userMapper.selectByUserName(authenticationToken.getUsername());
        logger.info(sysUser.toString());
        if (!authenticationToken.getUsername().equals(sysUser.getUsername())) {
            return null;
        }
        return new SimpleAuthenticationInfo("", sysUser.getPassword(), "");
    }
}
