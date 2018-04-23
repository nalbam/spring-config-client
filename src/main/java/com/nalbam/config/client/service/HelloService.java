package com.nalbam.config.client.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class HelloService {

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello(Integer rate) {
        List<String> greetings = Arrays.asList("Hi there", "Greetings", "Lok'tar ogar");

        Random random = new Random();

        if (rate > random.nextInt(100)) {
            // Success
            return greetings.get(random.nextInt(greetings.size()));
        }

        // Error
        return greetings.get(greetings.size());
    }

    private String helloFallback(Integer rate) {
        return "Bye";
    }

}
