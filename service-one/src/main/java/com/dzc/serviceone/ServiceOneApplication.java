package com.dzc.serviceone;

import com.dzc.common.util.RestTemplateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class ServiceOneApplication {

    /**
     * 在本模块启动时，向Spring IoC注入一个 RestTemplate工具的实例化 的Bean，以供模块内部使用
     */
    @Bean
    public RestTemplateUtil restTemplateUtil() {
        return new RestTemplateUtil();
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceOneApplication.class, args);
    }

}
