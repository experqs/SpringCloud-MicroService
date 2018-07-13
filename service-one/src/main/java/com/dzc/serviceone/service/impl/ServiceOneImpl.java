package com.dzc.serviceone.service.impl;

import com.dzc.common.model.Result;
import com.dzc.common.util.RestTemplateUtil;
import com.dzc.common.util.ResultUtil;
import com.dzc.serviceone.service.ServiceOne;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceOneImpl implements ServiceOne {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用RestTemplate封装工具，消费【外部服务API】
     */
    @Override
    public Result getStock(String stock) {
        String url = "http://qt.gtimg.cn/";
        Map<String, String> paramsMap = new HashMap<>();
        if (StringUtils.isEmpty(stock)) {
            // 股票代码为空则获取沪指
            paramsMap.put("q", "sh000001");
        } else {
            paramsMap.put("q", stock);
        }
        // 使用封装过的restTemplate工具调用外部API
        ResponseEntity<String> response = restTemplateUtil.get(url, paramsMap, String.class, null);
        return ResultUtil.success(response.getBody());
    }

    /**
     * 使用 RestTemplate + Ribbon，消费【内部服务API】
     *
     * 此restTemplate实例使用@LoadBalanced注解开启了Ribbon的负载均衡功能，要使得负载均衡有效就不能直接指定目标服务的具体url地址（IP+端口号）
     * 这里用的服务名替代了具体的url地址，Ribbon会根据服务名来选择具体的服务实例（若实例有多个，则轮询使用，实现负载均衡），并使用具体的url替换掉服务名
     * （如果不启用@LoadBalanced，则无法把服务名替换为url地址）
     */
    @Override
    public Result helloServiceTwoRestTemplate(Integer id) {
        String url = "http://service-two/hello";
        if (id != null) {
            String params = "?id=" + id;
            url = url + params;
        }
        // 使用原生的restTemplate调用内部API
        String response = restTemplate.getForObject(url, String.class);
        return ResultUtil.success(response);
    }

}
