package com.dzc.serviceone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerOne {

    @GetMapping("*")
    public String index() {
        String str = "This URL doesn't exist in ServiceOne.";
        return str;
    }

    @GetMapping("/")
    public String init() {
        String str = "ServiceOne Home Page.";
        return str;
    }

    @GetMapping("/hello")
    public String hello() {
        String str = "Hello! ServiceOne!";
        return str;
    }

}
