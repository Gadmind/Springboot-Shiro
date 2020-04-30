package com.daop.security.service.impl;

import com.daop.security.entity.SysPermission;
import com.daop.security.entity.SysRole;
import com.daop.security.entity.SysUser;
import com.daop.security.mapper.SysUserMapper;
import com.daop.security.service.SysPermissionService;
import com.daop.security.service.SysRoleService;
import com.daop.security.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.service.impl
 * @Description:
 * @DATE: 2020-04-29
 * @AUTHOR: Administrator
 **/
@Service
public class SysUserServiceImpl implements SysUserService {
    Logger logger=LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Resource
    SysUserMapper userMapper;
    @Resource
    SysRoleService roleService;
    @Resource
    SysPermissionService permissionService;

    @Override
    public SysUser getSysUserByUserName(String userName) {
        SysUser sysUser = userMapper.selectSysUserByUserName(userName);
        logger.info(sysUser.toString());

        List<SysRole> roles = roleService.listRolesByUserId(sysUser.getId());
        sysUser.setRoles(roles);
        for (SysRole role : roles) {
            List<SysPermission> permissions = permissionService.listPsermissionsByRoleId(role.getId());
            role.setPermissions(permissions);
        }
        return sysUser;
    }


}
