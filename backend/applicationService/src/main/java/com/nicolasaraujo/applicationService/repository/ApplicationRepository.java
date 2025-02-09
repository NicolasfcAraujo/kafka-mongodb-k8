package com.nicolasaraujo.applicationService.repository;

import com.nicolasaraujo.applicationService.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ApplicationRepository extends MongoRepository<Application, String> {

    List<Application> findAllByCandidateId(String id);
}
