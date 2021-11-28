package com.manning.application.notification.template.formatter.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class NotificationTemplateRequest {

    private List<NotificationParameters> notificationParameters;
    private String notificationTemplateName;
    private String notificationMode;

}
