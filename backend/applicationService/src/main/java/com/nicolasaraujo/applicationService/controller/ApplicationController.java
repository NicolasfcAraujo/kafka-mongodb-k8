package com.nicolasaraujo.applicationService.controller;

import com.nicolasaraujo.applicationService.dto.ApplicationDTO;
import com.nicolasaraujo.applicationService.model.Application;
import com.nicolasaraujo.applicationService.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Application>> getApplicationById(@PathVariable String id) {
        return new ResponseEntity<>(applicationService.getApplicationById(id), HttpStatus.OK);
    }

    @GetMapping("/by-candidate-id/{id}")
    public List<Application> getAllApplicationsByCandidateId(@PathVariable String id) {
        return applicationService.getAllApplicationsByCandidateId(id);
    }

    @PostMapping
    public Application createApplication(@RequestBody ApplicationDTO applicationDTO) {
        return applicationService.createApplication(applicationDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Application>> updateApplication(@PathVariable String id, @RequestBody ApplicationDTO applicationDTO) {
        return new ResponseEntity<>(applicationService.updateApplication(id, applicationDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable String id) {
        applicationService.deleteApplication(id);

        return ResponseEntity.noContent().build();
    }
}
