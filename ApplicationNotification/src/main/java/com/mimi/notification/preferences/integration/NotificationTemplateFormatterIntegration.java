package com.mimi.notification.preferences.integration;

import com.mimi.notification.preferences.model.NotificationTemplateRequest;
import com.mimi.notification.preferences.model.NotificationTemplateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@Slf4j
public class NotificationTemplateFormatterIntegration {

    @Value("${notification.templates.url}")
    private String notificationTemplatesUrl;

    public NotificationTemplateResponse getNotificationTemplateFormatter(NotificationTemplateRequest notificationTemplateRequest)  {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NotificationTemplateResponse> response = restTemplate.postForEntity(notificationTemplatesUrl,notificationTemplateRequest, NotificationTemplateResponse.class);
        log.info(" ******** Response " + response.getBody());
        return response.getBody();
    }


}
