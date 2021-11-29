package com.manning.application.notification.integration;

import com.manning.application.notification.model.NotificationPreferencesRequest;
import com.manning.application.notification.model.NotificationPreferencesResponse;
import com.manning.application.notification.model.NotificationTemplateRequest;
import com.manning.application.notification.model.NotificationTemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;

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
