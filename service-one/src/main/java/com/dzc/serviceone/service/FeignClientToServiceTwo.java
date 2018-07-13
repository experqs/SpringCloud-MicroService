package com.dzc.serviceone.service;

import com.dzc.common.model.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用Feign，消费【内部服务API】
 *
 * Feign是一个声明式的伪Http客户端，采用的是基于接口的注解，即只需要创建一个接口并注解@FeignClient，即可使用Feign；
 * 且Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。
 *
 * （服务的提供者和消费者双方都需要注册到Eureka）
 * 此注解通过设置 value = "service-two" 指出将要消费的服务名称，即可在Eureka注册中心找到对应的服务地址；
 * 如果service-two服务启动了多个实例（每个实例使用不同的IP或端口），则Feign客户端默认使用轮询的方式来消费具体的服务实例，实现了负载均衡的效果。
 */
@FeignClient(value = "service-two")
public interface FeignClientToServiceTwo {

    @GetMapping("/hello")
    Result hello(@RequestParam(value = "id", required = false) Integer id);

}
