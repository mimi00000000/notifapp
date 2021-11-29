package com.manning.application.notification.model;


import com.manning.application.notification.entities.NotificationParameters;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NotificationTemplateRequest {

    private List<NotificationParameters> notificationParameters;
    private String notificationTemplateName;
    private String notificationMode;

}
