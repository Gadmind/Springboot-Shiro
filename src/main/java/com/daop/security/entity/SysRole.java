package com.daop.security.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.entity
 * @Description: ${DESCRIPTION}
 * @DATE: 2020-04-29
 * @AUTHOR: Administrator
 **/
public class SysRole implements Serializable {
    /**
     * 角色ID
     */
    private String id;

    /**
     * 角色名
     */
    private String rolename;
    /**
     * 角色对应的权限集合
     */
    private List<SysPermission> permissions;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public SysRole(String id, String rolename, List<SysPermission> permissions) {
        this.id = id;
        this.rolename = rolename;
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id='" + id + '\'' +
                ", rolename='" + rolename + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}