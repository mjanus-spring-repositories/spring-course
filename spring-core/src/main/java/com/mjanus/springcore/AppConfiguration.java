package com.mjanus.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AppConfiguration {

    @Bean
    public BeanMonitor beanMonitor() {
        return new BeanMonitor();
    }
}
