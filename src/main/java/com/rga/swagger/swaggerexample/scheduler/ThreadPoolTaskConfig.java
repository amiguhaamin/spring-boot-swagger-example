package com.rga.swagger.swaggerexample.scheduler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(basePackages = "com.rga.swagger.swaggerexample.scheduler",
        basePackageClasses = { ThreadPoolTaskScheduler.class })
public class ThreadPoolTaskConfig {

    @Value("${app.restart-in-minutes}")
    private int restartTime;

    @Bean
    public PeriodicTrigger periodicTrigger() {
        return new PeriodicTrigger(restartTime, TimeUnit.MINUTES);
    }

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(1);
        threadPoolTaskScheduler.setThreadNamePrefix("callbackTaskScheduler");
        return threadPoolTaskScheduler;
    }

}
