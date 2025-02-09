package com.nicolasaraujo.notificationService.dto;

public record NotificationDTO(
        String receiverId,
        String subject,
        String content
) {
}
