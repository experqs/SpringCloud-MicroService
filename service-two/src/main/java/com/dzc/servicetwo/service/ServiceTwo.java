package com.dzc.servicetwo.service;

import com.dzc.common.model.Result;

public interface ServiceTwo {

    String hello(Integer id);

    Result helloMany(Integer idBegin, Integer idEnd, int pageNum, int limit);

    Result accessWait(Integer id);

    Result accessNow(Integer id);

    Result accessSomeTime(Integer id);
}
