package com.nalbam.config.client.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class HelloService {

    private List<String> greetings = Arrays.asList("Hi there", "Greetings", "Lok'tar ogar");

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello(Integer rate) {
        Random random = new Random();

        if (rate > random.nextInt(100)) {
            return greetings.get(random.nextInt(greetings.size())) + " " + rate;
        }

        return greetings.get(greetings.size());
    }

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello20() {
        Integer rate = 20;
        Random random = new Random();

        if (rate > random.nextInt(100)) {
            return greetings.get(random.nextInt(greetings.size())) + " " + rate;
        }

        return greetings.get(greetings.size());
    }

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello40() {
        Integer rate = 40;
        Random random = new Random();

        if (rate > random.nextInt(100)) {
            return greetings.get(random.nextInt(greetings.size())) + " " + rate;
        }

        return greetings.get(greetings.size());
    }

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello60() {
        Integer rate = 60;
        Random random = new Random();

        if (rate > random.nextInt(100)) {
            return greetings.get(random.nextInt(greetings.size())) + " " + rate;
        }

        return greetings.get(greetings.size());
    }

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello80() {
        Integer rate = 80;
        Random random = new Random();

        if (rate > random.nextInt(100)) {
            return greetings.get(random.nextInt(greetings.size())) + " " + rate;
        }

        return greetings.get(greetings.size());
    }

    private String helloFallback(Integer rate) {
        return "Bye " + rate;
    }

}
