package com.daop.security.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: Springboot-Shiro
 * @BelongsPackage: com.daop.security.entity
 * @Description: ${DESCRIPTION}
 * @DATE: 2020-06-04
 * @AUTHOR: Administrator
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRole implements Serializable {
    /**
     * 角色ID
     */
    private String id;

    /**
     * 角色类型
     */
    private String roletype;

    /**
     * 角色名
     */
    private String rolename;

    private static final long serialVersionUID = 1L;
}