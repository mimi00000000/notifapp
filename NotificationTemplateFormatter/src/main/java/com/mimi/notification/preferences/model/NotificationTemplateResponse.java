package com.manning.application.notification.template.formatter.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NotificationTemplateResponse {

    private String status;
    private String statusDescription;
    private String emailContent;
    private String smsContent;
    private String emailSubject;
}
