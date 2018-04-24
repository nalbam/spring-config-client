package com.nalbam.config.client.controller;

import com.nalbam.config.client.service.HelloRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    private HelloRequestService helloRequestService;

    @GetMapping(value = "/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "Ben") String name,
                        @RequestParam(value = "rate", defaultValue = "100") Integer rate) {
        return helloRequestService.hello(name, rate);
    }

}
