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

    @GetMapping(value = "/hello20")
    public String hello20() {
        return helloService.hello20();
    }

    @GetMapping(value = "/hello40")
    public String hello40() {
        return helloService.hello40();
    }

    @GetMapping(value = "/hello60")
    public String hello60() {
        return helloService.hello60();
    }

    @GetMapping(value = "/hello80")
    public String hello80() {
        return helloService.hello80();
    }

}
