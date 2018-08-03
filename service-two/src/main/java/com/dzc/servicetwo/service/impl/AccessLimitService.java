package com.dzc.servicetwo.service.impl;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * com.google.guava提供的 RateLimiter 是基于令牌桶算法的实现类，可以对来自外部的访问请求进行限流
 */
@Component
public class AccessLimitService {

    // 设定每秒向令牌桶放入的令牌数量
    RateLimiter rateLimiter = RateLimiter.create(2);

    /**
     * 等候获得令牌（阻塞线程）
     * 一直阻塞等候，直到获得令牌，才返回true
     * @return
     */
    public boolean acquire() {
        double waitedTime = rateLimiter.acquire();
        System.out.println("waited: " + waitedTime);
        return true;
    }

    /**
     * 尝试即时获得令牌（不阻塞线程）
     * 判断能否即时获得令牌，若能则立即返回true；若不能则立即返回false
     * @return
     */
    public boolean tryAcquire() {
        return rateLimiter.tryAcquire();
    }

    /**
     * 尝试在给定时间内获得令牌（不阻塞线程）
     * 判断能否在给定的时间内获得令牌，若能则立即返回true；若不能则立即返回false
     * @return
     */
    public boolean tryAcquire(long timeout, TimeUnit unit) {
        return rateLimiter.tryAcquire(timeout, unit);
    }
}
