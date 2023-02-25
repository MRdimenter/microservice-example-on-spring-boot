package org.example.notification;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/v1/notifications")
public record NotificationRestController(NotificationService notificationService) {


    @PostMapping()
    public void sendNotification(@RequestBody Notification notification) {
        notificationService.sendNotification(notification);
    }

    @GetMapping
    public List<Notification> responseNotifications() {
        return notificationService.responseNotifications();
    }

}
