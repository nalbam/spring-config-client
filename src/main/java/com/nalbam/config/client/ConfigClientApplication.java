package com.nalbam.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

}
