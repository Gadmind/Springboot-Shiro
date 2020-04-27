package com.daop.security.controller;

import com.daop.security.customexception.ErrorEnum;
import com.daop.security.util.ResultUtil;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.controller
 * @Description: 资源未找到控制器
 * @DATE: 2020-04-27 21:33
 * @AUTHOR: Daop
 **/
@RestController
public class NotFoundException implements ErrorController {
    /**
     * 全局错误路径
     */
    private static final String ERROR_PATH = "/error";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(ERROR_PATH)
    public ResultUtil error() {
        return ResultUtil.otherError(ErrorEnum.NOT_FOUND);
    }
}
