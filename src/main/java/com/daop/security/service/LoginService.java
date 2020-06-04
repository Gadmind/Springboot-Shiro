package com.daop.security.service;

import com.daop.security.entity.SysUser;

/**
 * @BelongsProject: Springboot-Shiro
 * @BelongsPackage: com.daop.security.service
 * @Description:
 * @DATE: 2020-06-04
 * @AUTHOR: Administrator
 **/
public interface LoginService {
    SysUser login(String username, String password);
}
