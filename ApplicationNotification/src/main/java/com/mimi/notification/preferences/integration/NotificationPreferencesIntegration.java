package com.mimi.notification.preferences.integration;

import com.mimi.notification.preferences.model.NotificationPreferencesRequest;
import com.mimi.notification.preferences.model.NotificationPreferencesResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@Slf4j
public class NotificationPreferencesIntegration {


    @Value("${notification.preferences.url}")
    private String notificationPreferencesUrl;

    public NotificationPreferencesResponse getNotificationPreferencesResponse(NotificationPreferencesRequest notificationPreferencesRequest)  {
        RestTemplate restTemplate = new RestTemplate();
        log.info(" ******** CutomerId " + notificationPreferencesRequest.getCustomerId());
        ResponseEntity<NotificationPreferencesResponse> response = restTemplate.postForEntity(notificationPreferencesUrl,notificationPreferencesRequest, NotificationPreferencesResponse.class);
        log.info(" ********  Response "+ response.getBody());
        return response.getBody();
    }


}
