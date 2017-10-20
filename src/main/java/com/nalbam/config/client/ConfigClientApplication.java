package com.nalbam.config.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ConfigClientApplication {

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

}
