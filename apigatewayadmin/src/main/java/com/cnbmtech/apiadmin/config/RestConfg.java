package com.cnbmtech.apiadmin.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfg {
    @Bean
    public RestTemplate addRestTemplate() {
    	return new RestTemplate();
    }
}