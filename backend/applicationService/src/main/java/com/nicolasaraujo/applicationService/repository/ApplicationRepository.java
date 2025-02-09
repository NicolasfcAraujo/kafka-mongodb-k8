package com.nicolasaraujo.applicationService.repository;

import com.nicolasaraujo.applicationService.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplicationRepository extends MongoRepository<Application, String> {
}
