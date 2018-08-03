package com.dzc.common.util;

import com.dzc.common.model.HttpStatus;
import com.dzc.common.model.Result;

/**
 * 组装返回数据体工具
 */
public class ResultUtil {

    /**
     * 返回 200 成功
     * @param data
     * @return
     */
    public static Result success(Object data) {
        Result<Object> result = new Result<>();
        result.setCode(HttpStatus.SUCCESS.getCode());
        result.setMsg(HttpStatus.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 返回 500 失败（Server Error）
     * @param data
     * @return
     */
    public static Result fail(Object data) {
        Result<Object> result = new Result<>();
        result.setCode(HttpStatus.FAIL.getCode());
        result.setMsg(HttpStatus.FAIL.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 返回 503 服务器过载（Unavailable）
     * @param data
     * @return
     */
    public static Result unavailable(Object data) {
        Result<Object> result = new Result<>();
        result.setCode(HttpStatus.UNAVAILABLE.getCode());
        result.setMsg(HttpStatus.UNAVAILABLE.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 返回 401 unauthorized
     * @param data
     * @return
     */
    public static Result unauthorized(Object data) {
        Result<Object> result = new Result<>();
        result.setCode(HttpStatus.UNAUTHORIZED.getCode());
        result.setMsg(HttpStatus.UNAUTHORIZED.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 返回 403 forbidden
     * @param data
     * @return
     */
    public static Result forbidden(Object data) {
        Result<Object> result = new Result<>();
        result.setCode(HttpStatus.FORBIDDEN.getCode());
        result.setMsg(HttpStatus.FORBIDDEN.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 返回 404 notFound
     * @param data
     * @return
     */
    public static Result notFound(Object data) {
        Result<Object> result = new Result<>();
        result.setCode(HttpStatus.NOT_FOUND.getCode());
        result.setMsg(HttpStatus.NOT_FOUND.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 自定义返回结果
     * @param code 状态编码
     * @param msg 状态消息
     * @param data 数据
     * @return
     */
    public static Result build(Integer code, String msg, Object data) {
        Result<Object> result = new Result<>(code, msg, data);
        return result;
    }
}
