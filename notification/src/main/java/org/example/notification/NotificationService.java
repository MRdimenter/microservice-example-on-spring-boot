package org.example.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public record NotificationService(NotificationRepository notificationRepository) {

    public void sendNotification(Notification notification) {
        notificationRepository.save(notification);
    }

    public List<Notification> responseNotifications() {
        return notificationRepository.findAll();
    }
}
