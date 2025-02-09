package com.nicolasaraujo.jobService.repository;

import com.nicolasaraujo.jobService.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job, String> {
}
