package com.mimi.notification.preferences.model;

import java.util.List;


public class NotificationGatewayRequest {

    private String customerId;
    private String notificationMode;
    private String notificationContent;
    private String emailSubject;
    private String emailAddress;
    private String phoneNumber;

    public NotificationGatewayRequest() {
    }

    public NotificationGatewayRequest(String customerId, String notificationMode, String notificationContent, String emailSubject, String emailAddress, String phoneNumber) {
        this.customerId = customerId;
        this.notificationMode = notificationMode;
        this.notificationContent = notificationContent;
        this.emailSubject = emailSubject;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getNotificationMode() {
        return notificationMode;
    }

    public void setNotificationMode(String notificationMode) {
        this.notificationMode = notificationMode;
    }

    public String getNotificationContent() {
        return notificationContent;
    }

    public void setNotificationContent(String notificationContent) {
        this.notificationContent = notificationContent;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationGatewayRequest{");
        sb.append("customerId='").append(customerId).append('\'');
        sb.append(", notificationMode='").append(notificationMode).append('\'');
        sb.append(", notificationContent='").append(notificationContent).append('\'');
        sb.append(", emailSubject='").append(emailSubject).append('\'');
        sb.append(", emailAddress='").append(emailAddress).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
