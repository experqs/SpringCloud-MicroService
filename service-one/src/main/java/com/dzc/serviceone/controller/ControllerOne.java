package com.dzc.serviceone.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Service-One")
@RestController
public class ControllerOne {

    @ApiOperation(value = "Home Page", notes = "首页")
    @GetMapping("/")
    public String homepage() {
        String str = "ServiceOne Home Page.";
        return str;
    }

    @ApiOperation(value = "say hello", notes = "say hello")
    @GetMapping("/hello")
    public String hello() {
        String str = "Hello! ServiceOne!";
        return str;
    }

}
