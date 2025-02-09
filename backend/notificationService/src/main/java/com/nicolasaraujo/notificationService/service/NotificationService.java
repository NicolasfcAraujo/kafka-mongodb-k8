package com.nicolasaraujo.notificationService.service;

import com.nicolasaraujo.notificationService.dto.NotificationDTO;
import com.nicolasaraujo.notificationService.model.Notification;
import com.nicolasaraujo.notificationService.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Notification createNotification(NotificationDTO notificationDTO) {
        Notification notification = new Notification(notificationDTO);

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
