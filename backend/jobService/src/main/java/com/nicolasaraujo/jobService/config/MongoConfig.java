package com.nicolasaraujo.jobService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.nicolasaraujo.jobService.repository")
public class MongoConfig {
}
