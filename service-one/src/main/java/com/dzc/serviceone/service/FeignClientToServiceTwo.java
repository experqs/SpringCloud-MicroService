package com.dzc.serviceone.service;

import com.dzc.common.model.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-two")
public interface FeignClientToServiceTwo {

    @GetMapping("/hello")
    Result hello(@RequestParam(value = "id", required = false) Integer id);

}
