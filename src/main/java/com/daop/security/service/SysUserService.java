package com.daop.security.service;

import com.daop.security.entity.SysUser;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.service.impl
 * @Description: 用户业务接口
 * @DATE: 2020-04-29
 * @AUTHOR: Administrator
 **/
public interface SysUserService {
    SysUser getSysUserByUserName(String principal);

    SysUser getUserByLoginName(String username);
}
