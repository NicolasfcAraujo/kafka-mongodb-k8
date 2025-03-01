package com.nicolasaraujo.applicationService.dto;

public record ApplicationCreatedEventDTO(
        String receiverId,
        String subject,
        String content
) {
}
