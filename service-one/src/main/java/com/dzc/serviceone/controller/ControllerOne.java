package com.dzc.serviceone.controller;

import com.dzc.common.model.Result;
import com.dzc.common.util.ResultUtil;
import com.dzc.serviceone.service.FeignClientToServiceTwo;
import com.dzc.serviceone.service.ServiceOne;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Service-One")
@RestController
public class ControllerOne {

    @Autowired
    ServiceOne serviceOne;

    @Autowired
    FeignClientToServiceTwo feignClientToServiceTwo;

    @ApiOperation(value = "Home Page", notes = "首页", response = Result.class)
    @GetMapping("/")
    public Result homepage() {
        String str = "ServiceOne Home Page.";
        return ResultUtil.success(str);
    }

    @ApiOperation(value = "say hello", notes = "say hello", response = Result.class)
    @GetMapping("/hello")
    public Result hello() {
        String str = "Hello! ServiceOne!";
        return ResultUtil.success(str);
    }

    @ApiOperation(value = "【外部服务API】获取股价信息", notes = "获取股价信息，股票代码为空则获取沪指", response = Result.class)
    @GetMapping("/stock")
    public Result getStock(@RequestParam(value = "stock", required = false) String stock) {
        return serviceOne.getStock(stock);
    }

    @ApiOperation(value = "【内部服务API】ServiceTwo.hello", notes = "使用Feign，消费【内部服务API】ServiceTwo.hello", response = Result.class)
    @GetMapping("/helloServiceTwo")
    public Result helloServiceTwo(@RequestParam(value = "id", required = false) Integer id) {
        return feignClientToServiceTwo.hello(id);
    }

}
