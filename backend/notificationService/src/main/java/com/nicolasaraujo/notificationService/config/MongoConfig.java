package com.nicolasaraujo.notificationService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.nicolasaraujo.notificationService.repository")
public class MongoConfig {
}
