package com.example.profileDemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<String> sendNotification(){
        String notification = notificationService.send();

        return ResponseEntity.ok(notification);
    }
}


// here we don't want to send notification to the customer every time even in dev, staging environment so we separate it out.
// Here we use @Profile