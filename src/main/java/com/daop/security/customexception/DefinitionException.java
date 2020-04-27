package com.daop.security.customexception;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.customexception
 * @Description: 自定义异常处理类
 * @DATE: 2020-04-27 20:32
 * @AUTHOR: Daop
 **/
public class DefinitionException extends RuntimeException {
    protected Integer errorCode;
    protected String errorMessage;

    public DefinitionException() {
    }

    public DefinitionException(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
