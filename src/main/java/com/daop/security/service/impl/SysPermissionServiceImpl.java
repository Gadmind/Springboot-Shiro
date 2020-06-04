package com.daop.security.service.impl;

import com.daop.security.entity.SysPermission;
import com.daop.security.mapper.SysPermissionMapper;
import com.daop.security.service.SysPermissionService;
import com.daop.security.service.SysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public Set<String> listPermissionsByUserId(String id) {
        List<String> perms = permissionMapper.selectPermsByUserId(id);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms) {
            permsSet.addAll(Arrays.asList(perm.trim().split(",")));
        }
        return permsSet;
    }
}
