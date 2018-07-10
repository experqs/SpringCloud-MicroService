package com.dzc.common.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * RESTful API 通用返回数据体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    @ApiModelProperty(value = "响应状态编码")
    private Integer code;

    @ApiModelProperty(value = "响应状态消息")
    private String msg;

    @ApiModelProperty(value = "数据")
    private T data;

    @ApiModelProperty(value = "附加信息")
    private Object extra;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
