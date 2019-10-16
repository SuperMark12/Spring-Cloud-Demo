package com.cloud.spring.demo.controller;

import com.cloud.spring.demo.feign.HelloServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/test/feign")
@AllArgsConstructor
public class HelloController {

    private HelloServiceClient helloServiceClient;

    @GetMapping("/hello")
    public String sayHello(String name) {
        return helloServiceClient.sayHelloFromClientOne(name);
    }
}
