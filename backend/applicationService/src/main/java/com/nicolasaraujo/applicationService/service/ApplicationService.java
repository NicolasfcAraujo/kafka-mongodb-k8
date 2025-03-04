package com.nicolasaraujo.applicationService.service;

import com.nicolasaraujo.applicationService.dto.ApplicationCreatedEventDTO;
import com.nicolasaraujo.applicationService.dto.ApplicationDTO;
import com.nicolasaraujo.applicationService.model.Application;
import com.nicolasaraujo.applicationService.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Optional<Application> getApplicationById(String id) {
        return applicationRepository.findById(id);
    }

    public List<Application> getAllApplicationsByCandidateId(String id) {
        return applicationRepository.findAllByCandidateId(id);
    }

    public Application createApplication(ApplicationDTO applicationDTO) {
        Application application = new Application(applicationDTO);

        kafkaTemplate.send("create.application", application.getCandidateId());

        return applicationRepository.save(application);
    }

    public Optional<Application> updateApplication(String id, ApplicationDTO applicationDTO) {
        return applicationRepository.findById(id).map(application -> {
            application.setCandidateId(applicationDTO.candidateId());
            application.setJobId(applicationDTO.jobId());
            application.setApplicationStatus(applicationDTO.applicationStatus());

            return application;
        });
    }

    public void deleteApplication(String id) {
        applicationRepository.deleteById(id);
    }
}
