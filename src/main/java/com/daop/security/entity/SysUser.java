package com.daop.security.entity;

import java.io.Serializable;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.entity
 * @Description: ${DESCRIPTION}
 * @DATE: 2020-04-28 21:06
 * @AUTHOR: Daop
 **/
public class SysUser implements Serializable {
    /**
    * 用户ID
    */
    private Integer id;

    /**
    * 公司名称
    */
    private String companyname;

    /**
    * 登陆名
    */
    private String username;

    /**
    * 用户名
    */
    private String name;

    /**
    * 密码
    */
    private String password;

    /**
    * 用户邮箱
    */
    private String email;

    /**
    * 使用邮箱：1：使用；0：不使用
    */
    private Integer useemail;

    /**
    * 盐值
    */
    private String salt;

    /**
    * 用户状态
    */
    private String status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUseemail() {
        return useemail;
    }

    public void setUseemail(Integer useemail) {
        this.useemail = useemail;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", companyname=").append(companyname);
        sb.append(", username=").append(username);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", useemail=").append(useemail);
        sb.append(", salt=").append(salt);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}