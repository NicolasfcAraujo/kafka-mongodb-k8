package com.nicolasaraujo.applicationService.dto;

import com.nicolasaraujo.applicationService.model.ApplicationStatus;

public record ApplicationDTO(
        String candidateId,
        String jobId,
        ApplicationStatus applicationStatus
) {
}
