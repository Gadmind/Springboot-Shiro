package com.daop.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.daop.security.entity.SysUser;

/**
 * @BelongsProject: Springboot-Shiro
 * @BelongsPackage: com.daop.security.mapper
 * @Description: ${DESCRIPTION}
 * @DATE: 2020-06-04
 * @AUTHOR: Administrator
 **/
public interface SysUserMapper extends BaseMapper<SysUser> {
    int deleteByPrimaryKey(String id);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectSysUserByUserName(String userName);
}