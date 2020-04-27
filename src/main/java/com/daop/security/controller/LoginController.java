package com.daop.security.controller;

import com.daop.security.customexception.DefinitionException;
import com.daop.security.util.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/login")
    public ResultUtil login() {
        ResultUtil result = new ResultUtil();
        User user = new User();
        user.setUserId(10);
        user.setUserName("张三");
        result.setCode(200);
        result.setMessage("Success");
        result.setResult(user);
        return result;
    }

    @GetMapping("/exceptionTest")
    public ResultUtil deException() {
        throw new DefinitionException(400, "出错了");
    }

    @GetMapping("/exceptionTest1")
    public ResultUtil exception() {
        ResultUtil resultUtil = new ResultUtil();
        int a = 1 / 0;
        return resultUtil;
    }
}

class User {
    private Integer userId;
    private String userName;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
