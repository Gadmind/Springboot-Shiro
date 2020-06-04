package com.daop.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.daop.security.entity.SysRole;
import com.daop.security.mapper.SysRoleMapper;
import com.daop.security.service.SysRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleMapper roleMapper;

    @Override
    public List<SysRole> listRolesByUserId(String id) {
        return roleMapper.selectRolesByUserId(id);
    }

    @Override
    public Set<String> listRoleKeys(String UserId) {
        List<SysRole> roles = listRolesByUserId(UserId);
        Set<String> rolesSet = new HashSet<>();
        for (SysRole role : roles) {
            if (role != null) {
                rolesSet.addAll(Arrays.asList(role.getRoletype().trim().split(",")));
            }
        }
        return rolesSet;
    }
}
