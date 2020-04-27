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

    /**
     * 自定义返回结果
     *
     * @param code    状态码
     * @param message 提示信息
     * @param result  数据结果
     */
    public ResultUtil(Integer code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    /**
     * 自定义异常返回结果
     * @param defineException 自定义异常
     * @return 结果数据
     */
    public static ResultUtil defineError(DefinitionException defineException) {
        ResultUtil result = new ResultUtil();
        result.setCode(defineException.getErrorCode());
        result.setMessage(defineException.getErrorMessage());
        result.setResult(null);
        return result;
    }

    /**
     * 其他异常返回结果
     * @param errorEnum 自定义异常枚举
     * @return 结果数据
     */
    public static ResultUtil otherError(ErrorEnum errorEnum) {
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
