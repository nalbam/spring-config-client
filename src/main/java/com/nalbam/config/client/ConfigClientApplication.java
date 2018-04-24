package com.nalbam.config.client;

import com.nalbam.config.client.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name = "service-demo", configuration = RibbonConfig.class)
public class ConfigClientApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

}
