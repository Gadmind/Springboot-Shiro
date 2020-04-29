package com.daop.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.daop.security.entity.SysRole;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.mapper
 * @Description: ${DESCRIPTION}
 * @DATE: 2020-04-29
 * @AUTHOR: Administrator
 **/
public interface SysRoleMapper extends BaseMapper<SysRole> {
    int deleteByPrimaryKey(String id);

    @Override
    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}