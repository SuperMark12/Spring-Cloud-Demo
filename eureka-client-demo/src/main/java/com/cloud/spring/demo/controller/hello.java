package com.cloud.spring.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: Administrator
 * @date: 2019/10/16
 * @modified by:
 * @modified date:
 * @problem no:
 */
@RestController
@RequestMapping("/test")
public class hello {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    @HystrixCommand(fallbackMethod = "helloError")
    public String syaHello(@RequestParam(value = "name", defaultValue = "zhangsan") String name) {
        return "hello " + name + ", i am from port: " + port;
    }

    public String helloError(String name) {
        return "hello, " + name + ", sorry, error !";
    }
}
