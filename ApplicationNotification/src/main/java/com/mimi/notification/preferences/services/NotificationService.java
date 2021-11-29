package com.mimi.notification.preferences.services;

import com.mimi.notification.preferences.entities.Notification;
import com.mimi.notification.preferences.formatters.NotificationFormatter;
import com.mimi.notification.preferences.integration.NotificationGatewayIntegration;
import com.mimi.notification.preferences.integration.NotificationPreferencesIntegration;
import com.mimi.notification.preferences.integration.NotificationTemplateFormatterIntegration;
import com.mimi.notification.preferences.model.*;
import com.mimi.notification.preferences.repositories.NotificationRepository;
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

        NotificationPreferencesRequest notificationPreferencesRequest = notificationFormatter.formatNotificationPreferencesRequest(notificationRequest);
        NotificationPreferencesResponse notificationPreferencesResponse = notificationPreferencesIntegration.getNotificationPreferencesResponse(notificationPreferencesRequest);

        NotificationTemplateRequest notificationTemplateRequest = notificationFormatter.formatNotificationTemplateFormatter(notificationRequest,notificationPreferencesResponse);
        NotificationTemplateResponse notificationTemplateResponse = notificationTemplateFormatterIntegration.getNotificationTemplateFormatter(notificationTemplateRequest);

        NotificationGatewayRequest notificationGatewayRequest = notificationFormatter.formatNotificationGatewayRequest(notificationRequest,notificationPreferencesResponse,notificationTemplateResponse);
        NotificationGatewayResponse response = notificationGatewayIntegration.sendNotification(notificationGatewayRequest);
        NotificationResponse notificationResponse = notificationFormatter.formatNotificationResponse(notification);
        return notificationResponse;
    }


}
