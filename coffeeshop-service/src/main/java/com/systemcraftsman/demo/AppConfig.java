package com.systemcraftsman.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class AppConfig {
 
    @Value("${rest.template.timeout}")
    private int restTemplateTimeoutMs;
 
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(restTemplateTimeoutMs))
                .setReadTimeout(Duration.ofMillis(restTemplateTimeoutMs))
                .build();
    }
}