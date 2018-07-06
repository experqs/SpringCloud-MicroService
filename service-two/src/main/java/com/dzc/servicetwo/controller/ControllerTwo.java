package com.dzc.servicetwo.controller;

import com.dzc.servicetwo.service.ServiceTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTwo {

    @Autowired
    private ServiceTwo serviceTwo;

    @GetMapping("*")
    public String index() {
        String str = "This URL doesn't exist in ServiceTwo.";
        return str;
    }

    @GetMapping("/")
    public String init() {
        String str = "ServiceTwo Home Page.";
        return str;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "id", required = false) Integer id) {
        return serviceTwo.hello(id);
    }

}
