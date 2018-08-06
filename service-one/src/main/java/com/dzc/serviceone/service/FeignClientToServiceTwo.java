package com.dzc.serviceone.service;

import com.dzc.common.model.Result;
import com.dzc.serviceone.service.impl.FeignFallbackByHystrix;
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
 * 此注解通过设置 value = "service-two" 指出将要消费的目标服务名称，即可在Eureka注册中心找到对应的服务地址；
 * 如果service-two（目标服务）启动了多个实例（每个实例使用不同的IP或端口），
 * 则Feign客户端（消费者）默认使用轮询的方式来消费在注册中心返回的具体的服务实例地址，实现了负载均衡的效果。
 *
 * 在 Feign 上使用 Hystrix 熔断器功能：
 * 由于Feign是以接口形式工作的，没有具体方法的实现，无法通过@HystrixCommand注解的fallbackMethod属性来指定当发生熔断时的fallback方法；
 *     1、启动类需加上@EnableHystrix注解，且在配置文件中指定 feign.hystrix.enabled=true ；
 *     2、本接口加上注解@FeignClient，并通过fallback属性来指定当发生熔断时的fallback实现类（这个类需实现当前Feign接口）。
 */
@FeignClient(value = "service-two", fallback = FeignFallbackByHystrix.class)
public interface FeignClientToServiceTwo {

    @GetMapping("/hello")
    Result hello(@RequestParam(value = "id", required = false) Integer id);

}
