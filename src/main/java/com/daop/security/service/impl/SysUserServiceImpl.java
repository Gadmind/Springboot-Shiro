package com.daop.security.service.impl;

import com.daop.security.entity.SysPermission;
import com.daop.security.entity.SysRole;
import com.daop.security.entity.SysUser;
import com.daop.security.mapper.SysUserMapper;
import com.daop.security.service.SysUserService;
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
    @Resource
    SysUserMapper userMapper;

    @Override
    public SysUser getSysUserByUserName(String userName) {
        SysUser sysUser = userMapper.selectSysUserByUserName(userName);
        return sysUser;
    }


}
