package com.dzc.serviceone.service.impl;

import com.dzc.common.model.Result;
import com.dzc.common.util.RestTemplateUtil;
import com.dzc.common.util.ResultUtil;
import com.dzc.serviceone.service.ServiceOne;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceOneImpl implements ServiceOne {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

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
        // 使用restTemplate调用外部API
        ResponseEntity<String> response = restTemplateUtil.get(url, paramsMap, String.class, null);
        return ResultUtil.success(response.getBody());
    }

}
