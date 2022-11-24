package com.mimi.notification.preferences.integration;


import com.mimi.notification.preferences.model.NotificationGatewayRequest;
import com.mimi.notification.preferences.model.NotificationGatewayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class NotificationGatewayIntegration {

    @Value("${notification.gateway.url}")
    private String notificationGatewayUrl;

    public NotificationGatewayResponse sendNotification(NotificationGatewayRequest notificationGatewayRequest)  {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NotificationGatewayResponse> response = restTemplate.postForEntity(notificationGatewayUrl,notificationGatewayRequest, NotificationGatewayResponse.class);
        log.info(" ******** Response " + response.getBody().toString());
        return response.getBody();
    }


}
