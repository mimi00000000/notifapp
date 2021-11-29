package com.manning.application.notification.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationGatewayRequest {

    private String customerId;
    private String notificationMode;
    private String notificationContent;
    private String emailSubject;
    private String emailAddress;
    private String phoneNumber;

}
