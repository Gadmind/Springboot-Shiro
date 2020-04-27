package com.daop.security.interceptor;

import com.daop.security.customexception.DefinitionException;
import com.daop.security.customexception.ErrorEnum;
import com.daop.security.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @BelongsProject: Springboot-Shiro
 * @BelongsPackage: com.daop.security.interceptor
 * @Description: 全局异常处理
 * @DATE: 2020-04-27
 * @AUTHOR: Administrator
 **/
@ControllerAdvice(basePackages = "com.daop.security")
public class GlobalExceptionHandler {
    @ExceptionHandler(value = DefinitionException.class)
    @ResponseBody
    public ResultUtil exceptionHandler(DefinitionException e) {
        return ResultUtil.defineError(e);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultUtil otherExceptionHandler(Exception e) {
        if (e instanceof NoHandlerFoundException) {
            return ResultUtil.otherError(ErrorEnum.NOT_FOUND);
        }
        return ResultUtil.otherError(ErrorEnum.INTERNAL_SERVER_ERROR);
    }
}
