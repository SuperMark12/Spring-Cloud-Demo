package com.cloud.spring.demo.service.impl;

import com.cloud.spring.demo.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @author: Administrator
 * @date: 2019/10/16
 * @modified by:
 * @modified date:
 * @problem no:
 */
@Service
@AllArgsConstructor
public class HelloServiceImpl implements HelloService {

    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "helloError")
    public String sayHello(String name) {
        String APP_NAME = "EUREKA-CLIENT-DEMO";
        return restTemplate.getForObject("http://" + APP_NAME + "/test/hello?name=" + name, String.class);
    }

    public String helloError(String name) {
        return "hello, " + name + ", sorry, the system is error!";
    }
}
