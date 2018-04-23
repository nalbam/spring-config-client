package com.nalbam.config.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(@RequestParam(value = "rate", defaultValue = "100") Integer rate) {
        log.info("Access /hello?rate=" + rate);

        List<String> greetings = Arrays.asList("Hi there", "Greetings", "Lok'tar ogar");

        Random random = new Random();

        if (rate > random.nextInt(100)) {
            return greetings.get(random.nextInt(greetings.size()));
        }

        // Error
        return greetings.get(greetings.size());
    }

}
