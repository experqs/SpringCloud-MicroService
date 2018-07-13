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

    @ApiOperation(value = "向用户打招呼", notes = "传入用户Id，打招呼", response = Result.class)
    @GetMapping("/hello")
    public Result hello(@RequestParam(value = "id", required = false) Integer id) {
        return ResultUtil.success(serviceTwo.hello(id));
    }

}
