package com.daop.security.service.impl;

import com.daop.security.entity.SysUser;
import com.daop.security.service.LoginService;
import com.daop.security.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @BelongsProject: Springboot-Shiro
 * @BelongsPackage: com.daop.security.service.impl
 * @Description:
 * @DATE: 2020-06-04
 * @AUTHOR: Administrator
 **/
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private SysUserService userService;

    @Override
    public SysUser login(String username, String password) {
        SysUser sysUser = userService.getUserByLoginName(username);
        if (sysUser.getPassword().equals(password)) {
            return sysUser;
        }
        return null;
    }
}
