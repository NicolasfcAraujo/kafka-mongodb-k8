package com.nicolasaraujo.notificationService.controller;

import com.nicolasaraujo.notificationService.dto.NotificationDTO;
import com.nicolasaraujo.notificationService.model.Notification;
import com.nicolasaraujo.notificationService.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Notification>> getNotificationById(@PathVariable String id) {
        return new ResponseEntity<>(notificationService.getNotificationById(id), HttpStatus.OK);
    }

    @GetMapping("/by-receiver-id/{id}")
    public List<Notification> getAllNotificationsByReceiverId(@PathVariable String id) {
        return notificationService.getNotificationsByReceiverId(id);
    }

    @PostMapping
    public Notification createNotification(@RequestBody NotificationDTO notificationDTO) {
        return notificationService.createNotification(notificationDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Notification>> updateNotification(@PathVariable String id, @RequestBody NotificationDTO notificationDTO) {
        return new ResponseEntity<>(notificationService.updateNotification(id, notificationDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable String id) {
        notificationService.deleteNotification(id);

        return ResponseEntity.noContent().build();
    }
}
