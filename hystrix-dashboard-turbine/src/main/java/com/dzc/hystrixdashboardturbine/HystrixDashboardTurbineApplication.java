package com.dzc.hystrixdashboardturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Turbine对集群的Hystrix熔断情况进行聚合监控的入口启动类
 *
 * @EnableTurbine 开启对Turbine的支持（同时默认开启向注册中心Eureka进行服务注册）
 *     Turbine监控Hystrix集群的日志输出地址 http://localhost:${port}/turbine.stream
 * @EnableHystrixDashboard 开启Hystrix熔断器的图形化监控，即 hystrix-dashboard
 *     Hystrix的图形化监控地址 http://localhost:${port}/hystrix （在Web界面上填入上面的集群监控日志输出地址）
 */
@EnableTurbine
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardTurbineApplication.class, args);
    }

}
