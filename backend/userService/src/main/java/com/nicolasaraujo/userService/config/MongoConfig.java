package com.nicolasaraujo.userService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.nicolasaraujo.userService.repository")
public class MongoConfig {
}
