package com.dzc.servicetwo.service.impl;

import com.dzc.common.model.Result;
import com.dzc.common.util.ResultUtil;
import com.dzc.servicetwo.dao.ExampleDao;
import com.dzc.servicetwo.service.ServiceTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ServiceTwoImpl implements ServiceTwo {

    @Autowired
    ExampleDao exampleDao;

    @Autowired
    AccessLimitService accessLimitService;

    @Value("${spring.cloud.client.ipAddress}")
    private String serverIp;

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.cloud.client.ipAddress}" + ":" + "${server.port}")
    private String serverAddress;

    private String helloDao(Integer id) {
        if (id == null) {
            return "Hello! This is ServiceTwo! By " + serverAddress;
        }
        return "Hello! " + exampleDao.selectNameById(id) + "! By " + serverAddress;
    }

    @Override
    public String hello(Integer id) {
        try {
            Thread.sleep(3000);     // 模拟耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return helloDao(id);
    }

    @Override
    public Result accessWait(Integer id) {
        // 阻塞等候，直到获取到令牌
        if (!accessLimitService.acquire()) {
            String resultString = "一直等候，居然都等不到？";
            System.out.println(resultString);
            return ResultUtil.unavailable(resultString);
        }
        System.out.println("终于等到令牌了。");
        return ResultUtil.success(helloDao(id));
    }

    @Override
    public Result accessNow(Integer id) {
        // 判断能否即时获得令牌，若能则立即返回true；若不能则立即返回false（不会阻塞线程）
        if (!accessLimitService.tryAcquire()) {
            String resultString = "此时此刻服务器没有可用资源，即时返回结果给客户端。";
            System.out.println(resultString);
            return ResultUtil.unavailable(resultString);
        }
        System.out.println("此时此刻服务器有令牌。");
        return ResultUtil.success(helloDao(id));
    }

    @Override
    public Result accessSomeTime(Integer id) {
        // 判断能否在给定的时间内获得令牌，若能则立即返回true；若不能则立即返回false（不会阻塞线程）
        if (!accessLimitService.tryAcquire(300, TimeUnit.MILLISECONDS)) {
            String resultString = "服务器判断在给定时间内无法提供可用资源，即时返回结果给客户端。";
            System.out.println(resultString);
            return ResultUtil.unavailable(resultString);
        }
        System.out.println("服务器判断在给定时间内可以提供令牌。");
        return ResultUtil.success(helloDao(id));
    }

}
