package com.manning.application.notification.model;

import com.manning.application.notification.entities.NotificationParameters;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NotificationRequest {

    private String customerId;
    private String notificationMode;
    private List<NotificationParameters> notificationParameters;
    private String notificationTemplateName;

}
