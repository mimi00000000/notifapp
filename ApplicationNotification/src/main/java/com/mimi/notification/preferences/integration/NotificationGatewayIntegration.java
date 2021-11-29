package com.manning.application.notification.integration;

import com.manning.application.notification.model.NotificationGatewayRequest;
import com.manning.application.notification.model.NotificationGatewayResponse;
import com.manning.application.notification.model.NotificationTemplateRequest;
import com.manning.application.notification.model.NotificationTemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NotificationGatewayIntegration {


    public NotificationGatewayResponse sendNotification(NotificationGatewayRequest notificationGatewayRequest)  {
        RestTemplate restTemplate = new RestTemplate();
        String notificationPreferencesUrl
            = "http://localhost:8083/api/notifications/send";
        ResponseEntity<NotificationGatewayResponse> response
            = restTemplate.postForEntity(notificationPreferencesUrl,notificationGatewayRequest, NotificationGatewayResponse.class);
        System.out.println("Response"+response.getBody().toString());

        return response.getBody();
    }


}
