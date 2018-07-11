package com.dzc.common.util;

import com.google.common.collect.Maps;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * RestTemplate 封装工具
 */
@Slf4j
public class RestTemplateUtil {

    private RestTemplate restTemplate = new RestTemplate();

    private static final String CONTENT_TYPE = "Content-Type";

    private static final String APPLICATION_JSON = "application/json";

    private static final String APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";

    /**
     * GET 请求
     *
     * @param url       url
     * @param paramMap  GET请求参数，Map类型，允许为null
     * @param clazz     输出类型class
     * @param headerMap HTTP请求头，Map类型，允许为null
     * @return {@link ResponseEntity}
     */
    public <T> ResponseEntity<T> get(@NonNull String url, Map<String, ?> paramMap, @NonNull Class<T> clazz,
                                     Map<String, String> headerMap) throws RestClientException {
        String paramString = "";
        if (null != paramMap && paramMap.size() > 0) {
            StringBuilder paramStringBuilder = new StringBuilder();
            paramMap.forEach((k, v) -> paramStringBuilder.append("&").append(k).append("=").append("{").append(k).append("}"));
            // paramStringBuilder.append("&").append(k).append("=").append(v));
            paramString = "?" + paramStringBuilder.toString().substring(1);
        } else {
            paramMap = Maps.newHashMap();
        }
        log.info("请求URL=>{}, 参数=>{}", url + paramString, paramMap.toString());
        HttpHeaders headers = new HttpHeaders();
        if (null != headerMap && headerMap.size() > 0) {
            headerMap.forEach(headers::add);
        }
        log.debug("请求头=>{}", headers.toString());
        HttpEntity httpEntity = new HttpEntity<>(null, headers);
        return restTemplate.exchange(url + paramString, HttpMethod.GET, httpEntity, clazz, paramMap);
    }

    /**
     * POST 表单 请求
     *
     * @param url       url
     * @param paramMap  表单参数，Map类型，允许为null
     * @param clazz     输出类型class
     * @param headerMap HTTP请求头，Map类型，允许为null
     * @return {@link ResponseEntity}
     */
    public <T> ResponseEntity<T> postForm(@NonNull String url, Map<String, Object> paramMap, @NonNull Class<T> clazz,
                                          Map<String, String> headerMap) throws RestClientException {
        LinkedMultiValueMap<String, Object> linkedMultiValueMap = new LinkedMultiValueMap<>();
        if (null != paramMap && paramMap.size() > 0) {
            paramMap.forEach(linkedMultiValueMap::add);
        }
        log.info("请求URL=>{}, 参数=>{}", url, linkedMultiValueMap.toString());
        HttpHeaders headers = new HttpHeaders();
        if (null == headerMap) {
            headerMap = new HashMap<>(16);
        }
        headerMap.putIfAbsent(CONTENT_TYPE, APPLICATION_FORM_URLENCODED);
        headerMap.forEach(headers::add);
        log.debug("请求头=>{}", headers.toString());
        HttpEntity<LinkedMultiValueMap<String, Object>> httpEntity = new HttpEntity<>(linkedMultiValueMap, headers);
        return restTemplate.exchange(url, HttpMethod.POST, httpEntity, clazz, paramMap);
    }

    /**
     * POST json 请求
     *
     * @param url       url
     * @param param     json字符串参数，允许为null
     * @param clazz     输出类型class
     * @param headerMap HTTP请求头，Map类型，允许为null
     * @return {@link ResponseEntity}
     */
    public <T> ResponseEntity<T> postJson(@NonNull String url, String param, @NonNull Class<T> clazz, Map<String, String> headerMap) {
        if (null == param) {
            param = "";
        }
        log.info("请求URL=>{}, 参数=>{}", url, param);
        HttpHeaders headers = new HttpHeaders();
        if (null == headerMap) {
            headerMap = new HashMap<>(16);
        }
        headerMap.putIfAbsent(CONTENT_TYPE, APPLICATION_JSON);
        headerMap.forEach(headers::add);
        log.debug("请求头=>{}", headers.toString());
        HttpEntity<String> httpEntity = new HttpEntity<>(param, headers);
        return restTemplate.exchange(url, HttpMethod.POST, httpEntity, clazz, param);
    }
}
