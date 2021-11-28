package com.mimi.notification.preferences.controllers;


import com.mimi.notification.preferences.model.NotificationTemplateRequest;
import com.mimi.notification.preferences.model.NotificationTemplateResponse;
import com.mimi.notification.preferences.services.NotificationTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications/templates")
public class NotificationTemplateFormatterController {

    @Autowired
    private NotificationTemplateService notificationTemplateService;

    @PostMapping
    public NotificationTemplateResponse sendNotification(@RequestBody NotificationTemplateRequest notificationTemplateRequestRequest) {
        System.out.println(notificationTemplateRequestRequest.toString());
        NotificationTemplateResponse notificationTemplateResponse = notificationTemplateService.getNotificationMergedTemplate(notificationTemplateRequestRequest);
        return notificationTemplateResponse;
    }

}
