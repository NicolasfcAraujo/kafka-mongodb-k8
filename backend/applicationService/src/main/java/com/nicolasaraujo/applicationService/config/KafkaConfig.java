package com.nicolasaraujo.applicationService.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic createApplicationTopic() {
        return new NewTopic("create.application", 1, (short) 1);
    }
}
