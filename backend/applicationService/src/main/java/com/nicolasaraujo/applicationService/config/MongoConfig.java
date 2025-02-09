package com.nicolasaraujo.applicationService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.nicolasaraujo.applicationService.repository")
public class MongoConfig {
}
