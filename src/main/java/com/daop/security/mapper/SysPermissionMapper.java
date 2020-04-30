package com.daop.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.daop.security.entity.SysPermission;

import java.util.List;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.mapper
 * @Description: ${DESCRIPTION}
 * @DATE: 2020-04-29
 * @AUTHOR: Administrator
 **/
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
    int deleteByPrimaryKey(String id);

    @Override
    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    List<SysPermission> selectPermissionByRoleId(String id);
}