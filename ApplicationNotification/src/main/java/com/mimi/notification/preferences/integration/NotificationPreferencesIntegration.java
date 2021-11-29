package com.manning.application.notification.integration;

import com.manning.application.notification.model.NotificationPreferencesRequest;
import com.manning.application.notification.model.NotificationPreferencesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

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
