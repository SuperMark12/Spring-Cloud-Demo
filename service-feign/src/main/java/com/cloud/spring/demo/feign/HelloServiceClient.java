package com.cloud.spring.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @author: Administrator
 * @date: 2019/10/16
 * @modified by:
 * @modified date:
 * @problem no:
 */
@FeignClient(
        //微服务名称
        value = "eureka-client-demo",

        fallback = HelloServiceClientFallback.class
)
public interface HelloServiceClient {

    String API_PREFIX = "/test";

    @GetMapping(API_PREFIX + "/hello")
    String sayHelloFromClientOne(@RequestParam(value = "name") String name);
}
