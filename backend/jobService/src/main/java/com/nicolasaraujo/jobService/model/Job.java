package com.nicolasaraujo.jobService.model;

import com.nicolasaraujo.jobService.dto.JobDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "jobs")
public class Job {

    @Id
    private String id;
    private String title;
    private String description;
    private String employerId;

    public Job() {
    }

    public Job(String id, String title, String description, String employerId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.employerId = employerId;
    }

    public Job(JobDTO jobDTO) {
        this.title = jobDTO.title();
        this.description = jobDTO.description();
        this.employerId = jobDTO.employerId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmployerId() {
        return employerId;
    }

    public void setEmployerId(String employerId) {
        this.employerId = employerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(id, job.id) && Objects.equals(title, job.title) && Objects.equals(description, job.description) && Objects.equals(employerId, job.employerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, employerId);
    }
}
