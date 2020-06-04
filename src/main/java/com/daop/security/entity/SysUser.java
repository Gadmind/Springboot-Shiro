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
public class SysUser implements Serializable {
    /**
     * 用户ID
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    private static final long serialVersionUID = 1L;
}