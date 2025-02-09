package com.nicolasaraujo.jobService.controller;

import com.nicolasaraujo.jobService.dto.JobDTO;
import com.nicolasaraujo.jobService.model.Job;
import com.nicolasaraujo.jobService.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Job>> getJobById(@PathVariable String id) {
        return new ResponseEntity<>(jobService.getJobById(id), HttpStatus.OK);
    }

    @PostMapping
    public Optional<Job> createJob(@RequestBody JobDTO jobDTO) {
        return jobService.createJob(jobDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Job>> updateJob(@PathVariable String id, @RequestBody JobDTO jobDTO) {
        return new ResponseEntity<>(jobService.updateUser(id, jobDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable String id) {
        jobService.deleteJob(id);

        return ResponseEntity.noContent().build();
    }
}
