package com.mimi.notification.preferences.controllers;

import com.mimi.notification.preferences.model.NotificationRequest;
import com.mimi.notification.preferences.model.NotificationResponse;
import com.mimi.notification.preferences.services.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
@Slf4j
public class NotificationInitiationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public NotificationResponse sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info(" ******** Name "+ notificationRequest.getNotificationParameters().get(0).getNotificationParameterName());
        NotificationResponse notificationResponse = notificationService.saveNotification(notificationRequest);
        return notificationResponse;
    }

}
