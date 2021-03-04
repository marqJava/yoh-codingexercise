package com.yoh.codingexcercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Application entry point for the spring boot application
 */
@SpringBootApplication
@EnableAsync
public class CodingExcerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodingExcerciseApplication.class, args);
    }

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor tpte = new ThreadPoolTaskExecutor();
        tpte.setThreadNamePrefix("Asynchronous procesing==>");
        tpte.setQueueCapacity(100);
        tpte.setCorePoolSize(2);
        tpte.setMaxPoolSize(2);
        tpte.initialize();
        return tpte;
    }
}
