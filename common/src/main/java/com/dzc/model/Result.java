package com.dzc.model;

/**
 * RESTful API 通用数据返回格式
 */
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;
    private Object extra;

}
