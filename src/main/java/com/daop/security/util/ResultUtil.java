package com.daop.security.util;

import com.daop.security.customexception.DefinitionException;
import com.daop.security.customexception.ErrorEnum;

/**
 * @BelongsProject: Springboot-Shiro
 * @BelongsPackage: com.daop.security.util
 * @Description: 结果集工具类
 * @DATE: 2020-04-27
 * @AUTHOR: Administrator
 **/
public class ResultUtil<T> {
    private Integer code;
    private String message;
    private T result;

    public ResultUtil() {
    }

    public ResultUtil(Integer code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public static ResultUtil defineError(DefinitionException defineException) {
        ResultUtil result = new ResultUtil();
        result.setCode(defineException.getErrorCode());
        result.setMessage(defineException.getErrorMessage());
        result.setResult(null);
        return result;
    }

    public static ResultUtil otherError(ErrorEnum errorEnum){
        ResultUtil result = new ResultUtil();
        result.setCode(errorEnum.getErrorCode());
        result.setMessage(errorEnum.getErrorMessage());
        result.setResult(null);
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
