package com.nicolasaraujo.jobService.service;

import com.nicolasaraujo.jobService.client.UserServiceClient;
import com.nicolasaraujo.jobService.dto.JobDTO;
import com.nicolasaraujo.jobService.model.Job;
import com.nicolasaraujo.jobService.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserServiceClient userServiceClient;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Optional<Job> getJobById(String id) {
        return jobRepository.findById(id);
    }

    public Optional<Job> createJob(JobDTO jobDTO) {

        Boolean isEmployer = userServiceClient.isEmployerById(jobDTO.employerId());

        if (isEmployer) {
            Job job = new Job(jobDTO);

            return Optional.of(jobRepository.save(job));
        } else {
            return Optional.empty();
        }
    }

    public Optional<Job> updateUser(String id, JobDTO jobDTO) {
        return jobRepository.findById(id).map(job -> {
            job.setTitle(jobDTO.title());
            job.setDescription(jobDTO.description());
            job.setEmployerId(jobDTO.employerId());

            return jobRepository.save(job);
        });
    }

    public void deleteJob(String id) {
        jobRepository.deleteById(id);
    }
}
