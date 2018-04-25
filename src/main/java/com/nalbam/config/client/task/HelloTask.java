package com.nalbam.config.client.task;

import com.nalbam.config.client.service.HelloRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloTask {

    @Value("${task.enabled}")
    private Boolean enabled;

    @Autowired
    private HelloRequestService helloRequestService;

    @Scheduled(fixedRate = 100)
    public void send100() {
        if (!this.enabled) {
            return;
        }
        log.info("Task : " + helloRequestService.hello("Task100", 100));
    }

    @Scheduled(fixedRate = 100)
    public void send_33() {
        if (!this.enabled) {
            return;
        }
        log.info("Task : " + helloRequestService.hello33("Task-33"));
    }

    @Scheduled(fixedRate = 100)
    public void send_66() {
        if (!this.enabled) {
            return;
        }
        log.info("Task : " + helloRequestService.hello66("Task-66"));
    }

    @Scheduled(fixedRate = 100)
    public void send_99() {
        if (!this.enabled) {
            return;
        }
        log.info("Task : " + helloRequestService.hello99("Task-99"));
    }

}
