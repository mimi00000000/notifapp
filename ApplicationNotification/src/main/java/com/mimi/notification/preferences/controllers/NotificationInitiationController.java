package com.manning.application.notification.controllers;

import com.manning.application.notification.model.NotificationRequest;
import com.manning.application.notification.model.NotificationResponse;
import com.manning.application.notification.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationInitiationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public NotificationResponse sendNotification(@RequestBody NotificationRequest notificationRequest) {
        System.out.println("Name"+ notificationRequest.getNotificationParameters().get(0).getNotificationParameterName());

        NotificationResponse notificationResponse=notificationService.saveNotification(notificationRequest);
        return notificationResponse;
    }

}
