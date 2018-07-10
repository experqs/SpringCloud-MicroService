package com.dzc.common.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * RESTful API 通用返回数据体
 */
public class Result<T> implements Serializable {

    @ApiModelProperty(value = "响应状态编码")
    private Integer code;

    @ApiModelProperty(value = "响应状态消息")
    private String msg;

    @ApiModelProperty(value = "数据")
    private T data;

    @ApiModelProperty(value = "附加信息")
    private Object extra;

    public Result() {
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg, T data, Object extra) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.extra = extra;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }
}
