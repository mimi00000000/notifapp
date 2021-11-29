package com.manning.application.notification.services;

import com.manning.application.notification.formatters.NotificationFormatter;
import com.manning.application.notification.integration.NotificationGatewayIntegration;
import com.manning.application.notification.integration.NotificationPreferencesIntegration;
import com.manning.application.notification.integration.NotificationTemplateFormatterIntegration;
import com.manning.application.notification.model.*;
import com.manning.application.notification.repositories.NotificationRepository;
import com.manning.application.notification.entities.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationFormatter notificationFormatter;

    @Autowired
    private NotificationPreferencesIntegration notificationPreferencesIntegration;

    @Autowired
    private NotificationTemplateFormatterIntegration notificationTemplateFormatterIntegration;

    @Autowired
    private NotificationGatewayIntegration notificationGatewayIntegration;

    public NotificationResponse saveNotification(@RequestBody NotificationRequest notificationRequest) {
        Notification notification = notificationFormatter.formatNotificationRequest(notificationRequest);
        notification = notificationRepository.save(notification);
        NotificationPreferencesRequest notificationPreferencesRequest=notificationFormatter.formatNotificationPreferencesRequest(notificationRequest);
        NotificationPreferencesResponse notificationPreferencesResponse= notificationPreferencesIntegration.getNotificationPreferencesResponse(notificationPreferencesRequest);
        NotificationTemplateRequest notificationTemplateRequest=notificationFormatter.formatNotificationTemplateFormatter(notificationRequest,notificationPreferencesResponse);
        NotificationTemplateResponse notificationTemplateResponse= notificationTemplateFormatterIntegration.getNotificationTemplateFormatter(notificationTemplateRequest);
        NotificationGatewayRequest notificationGatewayRequest=notificationFormatter.formatNotificationGatewayRequest(notificationRequest,notificationPreferencesResponse,notificationTemplateResponse);
        NotificationGatewayResponse response=notificationGatewayIntegration.sendNotification(notificationGatewayRequest);
        NotificationResponse notificationResponse = notificationFormatter.formatNotificationResponse(notification);
        return notificationResponse;
    }


}
