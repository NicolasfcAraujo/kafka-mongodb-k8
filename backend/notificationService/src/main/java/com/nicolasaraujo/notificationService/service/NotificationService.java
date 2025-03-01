package com.nicolasaraujo.notificationService.service;

import com.nicolasaraujo.notificationService.dto.NotificationDTO;
import com.nicolasaraujo.notificationService.model.Notification;
import com.nicolasaraujo.notificationService.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<Notification> getNotificationById(String id) {
        return notificationRepository.findById(id);
    }

    public List<Notification> getNotificationsByReceiverId(String id) {
        return notificationRepository.findAllByReceiverId(id);
    }

    @KafkaListener(topics = "create.application", groupId = "notification-group")
    public Notification createApplicationNotification(@Payload String receiverId) {
        Notification notification = new Notification();

        notification.setReceiverId(receiverId);
        notification.setSubject("New Application");
        notification.setContent("Thank you for applying for the Job. We have received your application and will review it shortly. If your profile matches our requirements, we will contact you with the next steps.");

        return notificationRepository.save(notification);
    }

    public Optional<Notification> updateNotification(String id, NotificationDTO notificationDTO) {
        return notificationRepository.findById(id).map(notification -> {
            notification.setReceiverId(notificationDTO.receiverId());
            notification.setSubject(notificationDTO.subject());
            notification.setContent(notificationDTO.content());

            return notificationRepository.save(notification);
        });
    }

    public void deleteNotification(String id) {
        notificationRepository.deleteById(id);
    }
}
