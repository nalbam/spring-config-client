package com.nalbam.config.client.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloRequestService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello(String name, Integer rate) {
        String greeting = this.restTemplate.getForObject("http://api-gateway/service-demo/hello?rate=" + rate, String.class);
        return String.format("%s, %s!", greeting, name);
    }

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello33(String name) {
        String greeting = this.restTemplate.getForObject("http://api-gateway/service-demo/hello33", String.class);
        return String.format("%s, %s!", greeting, name);
    }

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello66(String name) {
        String greeting = this.restTemplate.getForObject("http://api-gateway/service-demo/hello66", String.class);
        return String.format("%s, %s!", greeting, name);
    }

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello99(String name) {
        String greeting = this.restTemplate.getForObject("http://api-gateway/service-demo/hello99", String.class);
        return String.format("%s, %s!", greeting, name);
    }

    private String helloFallback(String name, Integer rate) {
        return "Bye " + name + " " + rate;
    }

    private String helloFallback(String name) {
        return "Bye " + name;
    }

}
