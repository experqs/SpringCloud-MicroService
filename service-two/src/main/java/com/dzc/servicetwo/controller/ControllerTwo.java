package com.dzc.servicetwo.controller;

import com.dzc.common.model.Result;
import com.dzc.common.util.ResultUtil;
import com.dzc.servicetwo.service.ServiceTwo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Service-Two")
@RestController
public class ControllerTwo {

    @Autowired
    private ServiceTwo serviceTwo;

    @Value("${spring.cloud.client.ipAddress}" + ":" + "${server.port}")
    private String serverAddress;

    @ApiOperation(value = "Home Page", notes = "首页", response = Result.class)
    @GetMapping("/")
    public Result homepage() {
        String str = "ServiceTwo Home Page. By " + serverAddress;
        return ResultUtil.success(str);
    }

    @ApiOperation(value = "Say Hello", notes = "传入用户Id，Say Hello", response = Result.class)
    @GetMapping("/hello")
    public Result hello(@RequestParam(value = "id", required = false) Integer id) {
        return ResultUtil.success(serviceTwo.hello(id));
    }

    @ApiOperation(value = "access limit, wait until available", notes = "服务器限流，客户端保持等候直到返回结果")
    @GetMapping("/accessWait")
    public Result accessWait(@RequestParam(value = "id", required = false) Integer id) {
        return serviceTwo.accessWait(id);
    }

    @ApiOperation(value = "access limit, respond immediately", notes = "服务器限流，客户端希望即时返回结果")
    @GetMapping("/accessNow")
    public Result accessNow(@RequestParam(value = "id", required = false) Integer id) {
        return serviceTwo.accessNow(id);
    }

    @ApiOperation(value = "access limit, respond within some time", notes = "服务器限流，客户端希望在一定时间内返回结果")
    @GetMapping("/accessSomeTime")
    public Result accessSomeTime(@RequestParam(value = "id", required = false) Integer id) {
        return serviceTwo.accessSomeTime(id);
    }

}
