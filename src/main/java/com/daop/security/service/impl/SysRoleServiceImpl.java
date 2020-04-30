package com.daop.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.daop.security.entity.SysRole;
import com.daop.security.mapper.SysRoleMapper;
import com.daop.security.service.SysRoleService;
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
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleMapper roleMapper;
    @Override
    public List<SysRole> listRolesByUserId(String id) {
       return roleMapper.selectRolesByUserId(id);
    }
}
