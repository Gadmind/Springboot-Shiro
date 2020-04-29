package com.daop.security.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.entity
 * @Description: ${DESCRIPTION}
 * @DATE: 2020-04-29
 * @AUTHOR: Administrator
 **/
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
    /**
     * 用户对应的角色集合
     */
    private List<SysRole> roles;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}