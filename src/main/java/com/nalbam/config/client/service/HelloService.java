package com.nalbam.config.client.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class HelloService {

    private List<String> greetings = Arrays.asList("Hi there", "Greetings", "Lok'tar");

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello(Integer rate) {
        Random random = new Random();

        if (rate > random.nextInt(100)) {
            return greetings.get(random.nextInt(greetings.size())) + " " + rate;
        }

        return greetings.get(greetings.size());
    }

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello33() {
        Integer rate = 33;
        Random random = new Random();

        if (rate > random.nextInt(100)) {
            return greetings.get(random.nextInt(greetings.size())) + " " + rate;
        }

        return greetings.get(greetings.size());
    }

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello66() {
        Integer rate = 66;
        Random random = new Random();

        if (rate > random.nextInt(100)) {
            return greetings.get(random.nextInt(greetings.size())) + " " + rate;
        }

        return greetings.get(greetings.size());
    }

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello99() {
        Integer rate = 99;
        Random random = new Random();

        if (rate > random.nextInt(100)) {
            return greetings.get(random.nextInt(greetings.size())) + " " + rate;
        }

        return greetings.get(greetings.size());
    }

    private String helloFallback(Integer rate) {
        return "Bye " + rate;
    }

    private String helloFallback() {
        return "Bye";
    }

}
