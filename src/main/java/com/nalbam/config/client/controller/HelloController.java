package com.nalbam.config.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        log.info("Access /hello");

        List<String> greetings = Arrays.asList("Hi there", "Greetings", "Lok'tar ogar");
        Random rand = new Random();

        int randomNum = rand.nextInt(greetings.size());
        return greetings.get(randomNum);
    }

}
