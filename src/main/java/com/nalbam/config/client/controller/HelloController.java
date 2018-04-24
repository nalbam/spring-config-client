package com.nalbam.config.client.controller;

import com.nalbam.config.client.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/hello")
    public String hello(@RequestParam(value = "rate", defaultValue = "100") Integer rate) {
        return helloService.hello(rate);
    }

    @GetMapping(value = "/hello33")
    public String hello33() {
        return helloService.hello33();
    }

    @GetMapping(value = "/hello66")
    public String hello66() {
        return helloService.hello66();
    }

    @GetMapping(value = "/hello99")
    public String hello99() {
        return helloService.hello99();
    }

}
