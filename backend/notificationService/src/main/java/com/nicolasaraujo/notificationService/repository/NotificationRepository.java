package com.nicolasaraujo.notificationService.repository;

import com.nicolasaraujo.notificationService.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {

    List<Notification> findAllByReceiverId(String id);
}
