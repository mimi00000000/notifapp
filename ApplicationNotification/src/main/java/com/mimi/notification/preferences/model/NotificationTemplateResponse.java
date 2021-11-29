package com.manning.application.notification.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationTemplateResponse {

    private String status;
    private String statusDescription;
    private String emailContent;
    private String smsContent;
    private String emailSubject;

}
