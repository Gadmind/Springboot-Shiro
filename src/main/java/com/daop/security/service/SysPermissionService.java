package com.daop.security.service;

import com.daop.security.entity.SysPermission;

import java.util.List;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.service
 * @Description: 权限业务接口
 * @DATE: 2020-04-29
 * @AUTHOR: Administrator
 **/
public interface SysPermissionService {
    List<SysPermission> listPsermissionsByRoleId(String id);
}
