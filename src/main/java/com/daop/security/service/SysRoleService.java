package com.daop.security.service;

import com.daop.security.entity.SysRole;

import java.util.List;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.service
 * @Description: 角色业务接口
 * @DATE: 2020-04-29
 * @AUTHOR: Administrator
 **/
public interface SysRoleService {
    List<SysRole> listRolesByUserId(String id);
}
