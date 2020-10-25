package com.rga.swagger.swaggerexample.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RunnableOrCallableTask implements Runnable {

    @Override
    public void run() {
        try {
            log.info("I was snoozing...");
            log.info("Going back to hibernate mode.");
        } catch (Exception e) {
            e.printStackTrace();
            new RuntimeException(e);
        }

    }
}
