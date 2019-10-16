package com.cloud.spring.demo.controller;

import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/test/client")
public class hello {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String syaHello(@RequestParam(value = "name", defaultValue = "zhangsan") String name) {
        return "hello " + name + ", i am from port: " + port;
    }
}
