package com.dzc.servicetwo.service.impl;

import com.dzc.servicetwo.dao.ExampleDao;
import com.dzc.servicetwo.service.ServiceTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceTwoImpl implements ServiceTwo {

    @Autowired
    ExampleDao exampleDao;

    @Value("${spring.cloud.client.ipAddress}")
    private String serverIp;

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.cloud.client.ipAddress}" + ":" + "${server.port}")
    private String serverAddress;

    @Override
    public String hello(Integer id) {
        try {
            Thread.sleep(3000);     // 模拟耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (id == null) {
            return "Hello! This is ServiceTwo! By " + serverAddress;
        }
        return "Hello! " + exampleDao.selectNameById(id) + "! By " + serverAddress;
    }

}
