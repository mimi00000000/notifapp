package com.mimi.notification.preferences.integration;


import com.mimi.notification.preferences.model.NotificationGatewayRequest;
import com.mimi.notification.preferences.model.NotificationGatewayResponse;
import org.springframework.http.ResponseEntity;
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
