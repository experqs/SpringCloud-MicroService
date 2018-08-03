package com.dzc.common.model;

/**
 * RESTful API 返回的HTTP状态码
 */
public enum HttpStatus {

    SUCCESS(200, "成功"),
    FAIL(500, "失败"),    // Server Error
    UNAVAILABLE(503, "服务器过载"),
    UNAUTHORIZED(401, "抱歉，请登录"),
    FORBIDDEN(403, "抱歉，没有权限"),
    NOT_FOUND(404, "访问的资源不存在");

    private Integer code;
    private String msg;

    HttpStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
