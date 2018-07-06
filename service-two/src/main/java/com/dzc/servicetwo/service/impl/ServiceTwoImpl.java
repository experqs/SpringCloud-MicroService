package com.dzc.servicetwo.service.impl;

import com.dzc.servicetwo.dao.ExampleDao;
import com.dzc.servicetwo.service.ServiceTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/6.
 */
@Service
public class ServiceTwoImpl implements ServiceTwo {

    @Autowired
    ExampleDao exampleDao;

    @Override
    public String hello(Integer id) {
        if (id == null) {
            return "Hello! This is ServiceTwo!";
        }
        return "Hello! " + exampleDao.selectNameById(id);
    }

}
