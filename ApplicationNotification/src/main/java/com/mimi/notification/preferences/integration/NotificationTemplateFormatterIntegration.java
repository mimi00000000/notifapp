package com.mimi.notification.preferences.integration;

import com.mimi.notification.preferences.model.NotificationTemplateRequest;
import com.mimi.notification.preferences.model.NotificationTemplateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class NotificationTemplateFormatterIntegration {

    public NotificationTemplateResponse getNotificationTemplateFormatter(NotificationTemplateRequest notificationTemplateRequest)  {
        RestTemplate restTemplate = new RestTemplate();
        String notificationPreferencesUrl
            = "http://localhost:8082/api/notifications/templates";
        ResponseEntity<NotificationTemplateResponse> response
            = restTemplate.postForEntity(notificationPreferencesUrl,notificationTemplateRequest, NotificationTemplateResponse.class);
        System.out.println("Response"+response.getBody().toString());

        return response.getBody();
    }


}
