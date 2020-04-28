package com.daop.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.daop.security.entity.SysUser;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.mapper
 * @Description: ${DESCRIPTION}
 * @DATE: 2020-04-28 21:06
 * @AUTHOR: Daop
 **/
public interface SysUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);
    SysUser selectByUserName(String userName);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}