package com.rga.swagger.swaggerexample.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ThreadPoolTaskExecutor {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Autowired
    private PeriodicTrigger periodicTrigger;

    @Autowired
    private RunnableOrCallableTask runnableOrCallableTask;

    @PostConstruct
    public void runWithCronScheduler() {
        threadPoolTaskScheduler.schedule(runnableOrCallableTask, periodicTrigger);
    }
}
