package com.mimi.notification.preferences.controllers;

import com.mimi.notification.preferences.model.NotificationGatewayRequest;
import com.mimi.notification.preferences.model.NotificationGatewayResponse;
import com.mimi.notification.preferences.services.NotificationGatewayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications/send")
@Slf4j
public class NotificationGatewayController {

    @Autowired
    private NotificationGatewayService notificationGatewayService;

    @PostMapping
    public NotificationGatewayResponse sendNotification(@RequestBody NotificationGatewayRequest notificationGatewayRequest) {
        log.info(notificationGatewayRequest.toString());
        NotificationGatewayResponse notificationGatewayResponse = null;

        if (notificationGatewayRequest.getNotificationMode().equalsIgnoreCase("EMAIL")) {
            notificationGatewayResponse = notificationGatewayService.sendEmailNotification(notificationGatewayRequest);
        } else {
            notificationGatewayResponse = notificationGatewayService.sendSMSNotification(notificationGatewayRequest);
        }
        return notificationGatewayResponse;
    }

}
