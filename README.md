
## 微服务项目架构
基于 Spring Boot 和 Spring Cloud 的微服务项目架构


#### 1、服务注册中心
    - Eureka

#### 2、服务消费及负载均衡
    【服务生产者、消费者、注册中心】
    - Ribbon  负载均衡器
            （默认使用轮询规则）
    - Feign  基于接口、声明式的伪Http客户端
            （用于消费内部服务；默认集成了Ribbon实现负载均衡）
    - RestTemplate  访问REST服务的HTTP客户端
            （可消费内部、外部服务；消费内部服务时也可配置Ribbon实现负载均衡）

#### 3、服务限流
    【服务生产者】
    - RateLimit  com.google.guava提供的基于令牌桶算法的限流工具

#### 4、服务熔断及监控
    【服务消费者】
    - Hystrix  熔断器
    - HystrixDashboard  图形化监控Hystrix熔断器
    - Turbine  聚合监控Hystrix熔断器集群
    
#### 5、其它
    - RESTful  微服务的API风格
    - Swagger2  接口文档生成器，使RESTful接口可视化
    - Lombok  POJO类的代码辅助工具

