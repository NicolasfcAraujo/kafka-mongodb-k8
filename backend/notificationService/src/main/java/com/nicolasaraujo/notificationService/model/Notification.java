package com.nicolasaraujo.notificationService.model;

import com.nicolasaraujo.notificationService.dto.NotificationDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "notifications")
public class Notification {

    @Id
    private String id;
    private String receiverId;
    private String subject;
    private String content;

    public Notification() {
    }

    public Notification(String id, String receiverId, String subject, String content) {
        this.id = id;
        this.receiverId = receiverId;
        this.subject = subject;
        this.content = content;
    }

    public Notification(NotificationDTO notificationDTO) {
        this.receiverId = notificationDTO.receiverId();
        this.subject = notificationDTO.subject();
        this.content = notificationDTO.content();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(id, that.id) && Objects.equals(receiverId, that.receiverId) && Objects.equals(subject, that.subject) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, receiverId, subject, content);
    }
}
