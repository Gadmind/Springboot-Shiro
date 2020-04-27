package com.daop.security.customexception;

/**
 * @BelongsProject: security
 * @BelongsPackage: com.daop.security.customexception
 * @Description: 错误自定义
 * @DATE: 2020-04-27 20:35
 * @AUTHOR: Daop
 **/
public enum ErrorEnum {
    /**
     * 操作错误定义
     */
    SUCCESS(200, "OK"),
    NO_PERMISSION(403, "您暂无权限访问"),
    NO_AUTH(401, "请您先登录"),
    NOT_FOUND(404, "资源未找到"),
    INTERNAL_SERVER_ERROR(500, "服务器崩溃啦");
    /**
     * 错误状态码
     */
    private final Integer errorCode;
    /**
     * 错误信息
     */
    private final String errorMessage;

    ErrorEnum(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
