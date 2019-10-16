package com.cloud.spring.demo.feign;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: Administrator
 * @date: 2019/10/16
 * @modified by:
 * @modified date:
 * @problem no:
 */

@Component
public class HelloServiceClientFallback implements HelloServiceClient {

    @Override
    public String sayHelloFromClientOne(String name) {
        return "sorry, " + name + ", system error !";
    }
}
