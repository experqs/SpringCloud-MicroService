package com.dzc.serviceone.service.impl;

import com.dzc.common.model.Result;
import com.dzc.common.util.ResultUtil;
import com.dzc.serviceone.service.FeignClientToServiceTwo;
import org.springframework.stereotype.Component;

/**
 * 当使用Feign过程中发生熔断需要降级时，所采用的fallback实现类
 * （需注入到Spring IoC容器中）
 */
@Component
public class FeignFallbackByHystrix implements FeignClientToServiceTwo{

    @Override
    public Result hello(Integer id) {
        System.out.println("Feign消费ServiceTwo出错，启动熔断降级！");
        return ResultUtil.fail("Feign在消费ServiceTwo时出现熔断，这是来自Hystrix的降级处理！");
    }

}
