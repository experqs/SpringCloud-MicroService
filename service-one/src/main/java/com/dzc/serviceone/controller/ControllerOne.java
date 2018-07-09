package com.dzc.serviceone.controller;

import com.dzc.common.model.Result;
import com.dzc.common.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Service-One")
@RestController
public class ControllerOne {

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

}
