package com.manning.application.notification.formatters;

import com.manning.application.notification.entities.Notification;
import com.manning.application.notification.model.*;
import org.springframework.stereotype.Component;

@Component
public class NotificationFormatter {

    public Notification formatNotificationRequest(NotificationRequest notificationRequest) {
        Notification notification = new Notification();
        notification.setNotificationMode(notificationRequest.getNotificationMode());
        notification.setNotificationParameters(notificationRequest.getNotificationParameters());
        notification.setCustomerId(notificationRequest.getCustomerId());
        notification.setNotificationTemplateId(notificationRequest.getNotificationTemplateName());
        return notification;

    }

    public NotificationResponse formatNotificationResponse(Notification notification) {
        NotificationResponse notificationResponse=new NotificationResponse();
        if(notification.getId()!= null) {
            notificationResponse.setNotificationReferenceId(notification.getId());
            notificationResponse.setStatus("SUCCESS");
            notificationResponse.setStatusDescription("Notification Received Successfully");
        }
        else
        {
            notificationResponse.setStatus("ERROR");
            notificationResponse.setStatusDescription("Notification Failed");
        }
        return  notificationResponse;

    }

    public NotificationPreferencesRequest formatNotificationPreferencesRequest(NotificationRequest notificationRequest) {
        NotificationPreferencesRequest notificationPreferencesRequest = new NotificationPreferencesRequest();
        notificationPreferencesRequest.setCustomerId(notificationRequest.getCustomerId());
        return notificationPreferencesRequest;

    }

    public NotificationTemplateRequest formatNotificationTemplateFormatter(NotificationRequest notificationRequest, NotificationPreferencesResponse notificationPreferencesResponse) {
        NotificationTemplateRequest notificationTemplateRequest = new NotificationTemplateRequest();
       if(notificationPreferencesResponse.isEmailPreferenceFlag())
           notificationTemplateRequest.setNotificationMode("EMAIL");
       else if(notificationPreferencesResponse.isSmsPreferenceFlag())
           notificationTemplateRequest.setNotificationMode("SMS");

        notificationTemplateRequest.setNotificationTemplateName(notificationRequest.getNotificationTemplateName());
        notificationTemplateRequest.setNotificationParameters(notificationRequest.getNotificationParameters());
        return notificationTemplateRequest;
    }

    public NotificationGatewayRequest formatNotificationGatewayRequest(NotificationRequest notificationRequest, NotificationPreferencesResponse notificationPreferencesResponse, NotificationTemplateResponse notificationTemplateResponse) {
        NotificationGatewayRequest notificationGatewayRequest=new NotificationGatewayRequest();
        notificationGatewayRequest.setCustomerId(notificationRequest.getCustomerId());

        if(notificationTemplateResponse.getEmailContent()!= null) {
            notificationGatewayRequest.setNotificationContent(notificationTemplateResponse.getEmailContent());
            notificationGatewayRequest.setNotificationMode("EMAIL");
            notificationGatewayRequest.setEmailAddress(notificationPreferencesResponse.getEmailAddress());
            notificationGatewayRequest.setEmailSubject(notificationTemplateResponse.getEmailSubject());

        }
        else {
            notificationGatewayRequest.setNotificationContent(notificationTemplateResponse.getSmsContent());
            notificationGatewayRequest.setNotificationMode("SMS");
            notificationGatewayRequest.setPhoneNumber(notificationPreferencesResponse.getPhoneNumber());

        }

        return notificationGatewayRequest;
    }
}
