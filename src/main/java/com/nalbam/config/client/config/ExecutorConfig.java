package com.nalbam.config.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
public class ExecutorConfig extends AsyncConfigurerSupport {

    @Value("${spring.application.name:nalbam}")
    private String name;

    @Value("${async.core-pool-size:2}")
    private Integer coreSize;

    @Value("${async.max-pool-size:20}")
    private Integer maxSize;

    @Value("${async.queue-capacity:200}")
    private Integer capacity;

    @Override
    public Executor getAsyncExecutor() {
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix(this.name + "-");
        executor.setCorePoolSize(this.coreSize);
        executor.setMaxPoolSize(this.maxSize);
        executor.setQueueCapacity(this.capacity);
        executor.initialize();
        return executor;
    }

}
