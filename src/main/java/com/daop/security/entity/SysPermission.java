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
public class SysPermission implements Serializable {
    /**
     * 权限ID
     */
    private String id;

    /**
     * 权限名称
     */
    private String permissionname;

    /**
     * 权限标识码
     */
    private String permissioncode;

    private static final long serialVersionUID = 1L;
}