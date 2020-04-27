package com.daop.security.customexception;

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
    /**
     * 自定义返回错误结果
     *
     * @param e 自定义的异常类
     * @return 结果工具类
     */
    @ExceptionHandler(value = DefinitionException.class)
    @ResponseBody
    public ResultUtil exceptionHandler(DefinitionException e) {
        return ResultUtil.defineError(e);
    }

    /**
     * 其他异常处理方法
     *
     * @param e 其他异常
     * @return 结果工具类
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultUtil otherExceptionHandler(Exception e) {
        if (e instanceof NoHandlerFoundException) {
            return ResultUtil.otherError(ErrorEnum.NOT_FOUND);
        }
        return ResultUtil.otherError(ErrorEnum.INTERNAL_SERVER_ERROR);
    }
}
