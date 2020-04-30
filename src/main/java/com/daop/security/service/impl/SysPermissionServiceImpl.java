package com.daop.security.service.impl;

import com.daop.security.entity.SysPermission;
import com.daop.security.mapper.SysPermissionMapper;
import com.daop.security.service.SysPermissionService;
import com.daop.security.service.SysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.service.impl
 * @Description:
 * @DATE: 2020-04-29
 * @AUTHOR: Administrator
 **/
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Resource
    private SysPermissionMapper permissionMapper;
    @Override
    public List<SysPermission> listPsermissionsByRoleId(String id) {
        return permissionMapper.selectPermissionByRoleId(id);

    }
}
