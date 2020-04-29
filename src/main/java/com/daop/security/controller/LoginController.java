package com.daop.security.controller;

import com.daop.security.customexception.DefinitionException;
import com.daop.security.customexception.ErrorEnum;
import com.daop.security.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.controller
 * @Description: 登录控制器
 * @DATE: 2020-04-27 20:53
 * @AUTHOR: Daop
 **/
@RestController
public class LoginController {
    @PostMapping("/login")
    public ResultUtil login(String userName, String password) {
        System.out.println(userName + "" + password);
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            subject.login(token);
            return new ResultUtil(200, "登录成功", token);
        } catch (AuthenticationException e) {
            return ResultUtil.otherError(ErrorEnum.NO_VERIFY);
        }
    }

    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @GetMapping("/tt")
    public ResultUtil tt() {
        return new ResultUtil();
    }
}