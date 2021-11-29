package com.mimi.notification.preferences.integration;

import com.mimi.notification.preferences.model.NotificationPreferencesRequest;
import com.mimi.notification.preferences.model.NotificationPreferencesResponse;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class NotificationPreferencesIntegration {


    public NotificationPreferencesResponse getNotificationPreferencesResponse(NotificationPreferencesRequest notificationPreferencesRequest)  {
        RestTemplate restTemplate = new RestTemplate();
        String notificationPreferencesUrl
            = "http://localhost:8081/notification/preferences";
        System.out.println("CutomerId" + notificationPreferencesRequest.getCustomerId());
        ResponseEntity<NotificationPreferencesResponse> response
            = restTemplate.postForEntity(notificationPreferencesUrl,notificationPreferencesRequest, NotificationPreferencesResponse.class);
        System.out.println("Response"+response.getBody().toString());
        return response.getBody();
    }


}
