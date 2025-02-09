package com.nicolasaraujo.applicationService.model;

import com.nicolasaraujo.applicationService.dto.ApplicationDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "applications")
public class Application {

    @Id
    private String id;
    private String candidateId;
    private String jobId;
    private ApplicationStatus applicationStatus;

    public Application() {
    }

    public Application(String id, String candidateId, String jobId, ApplicationStatus status) {
        this.id = id;
        this.candidateId = candidateId;
        this.jobId = jobId;
        this.applicationStatus = status;
    }

    public Application(ApplicationDTO applicationDTO) {
        this.candidateId = applicationDTO.candidateId();
        this.jobId = applicationDTO.jobId();
        this.applicationStatus = applicationDTO.applicationStatus();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return Objects.equals(id, that.id) && Objects.equals(candidateId, that.candidateId) && Objects.equals(jobId, that.jobId) && applicationStatus == that.applicationStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, candidateId, jobId, applicationStatus);
    }
}
