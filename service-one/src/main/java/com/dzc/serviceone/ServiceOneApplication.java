package com.dzc.serviceone;

import com.dzc.common.util.RestTemplateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * ServiceOne入口启动类
 *
 * @EnableEurekaClient 开启向注册中心Eureka进行服务注册
 * @EnableFeignClients 启用Feign客户端
 * @EnableHystrix 开启Hystrix熔断器功能
 *     Hystrix的监控日志输出地址 http://localhost:${port}/hystrix.stream （需先引入spring-boot-starter-actuator）
 * @EnableHystrixDashboard 开启Hystrix熔断器的图形化监控，即 hystrix-dashboard
 *     Hystrix的图形化监控地址 http://localhost:${port}/hystrix （在Web界面上填入上面的监控日志输出地址）
 */
@EnableHystrixDashboard
@EnableHystrix
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ServiceOneApplication {

    /**
     * 在本服务模块启动时，向Spring IoC容器注入一个 封装过的RestTemplate的实例Bean，以供模块内部使用
     */
    @Bean
    public RestTemplateUtil restTemplateUtil() {
        return new RestTemplateUtil();
    }

    /**
     * 再注入一个原生的RestTemplate实例
     *
     * @LoadBalanced 表示这个RestTemplate实例开启了Ribbon的负载均衡功能（在消费内部服务时负载均衡才有意义）
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceOneApplication.class, args);
    }

}
