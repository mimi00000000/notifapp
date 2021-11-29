package com.mimi.notification.preferences.model;


import com.mimi.notification.preferences.entities.NotificationParameters;

import java.util.List;

public class NotificationRequest {

    private String customerId;
    private String notificationMode;
    private List<NotificationParameters> notificationParameters;
    private String notificationTemplateName;

    public NotificationRequest() {
    }

    public NotificationRequest(String customerId, String notificationMode, List<NotificationParameters> notificationParameters, String notificationTemplateName) {
        this.customerId = customerId;
        this.notificationMode = notificationMode;
        this.notificationParameters = notificationParameters;
        this.notificationTemplateName = notificationTemplateName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationRequest{");
        sb.append("customerId='").append(customerId).append('\'');
        sb.append(", notificationMode='").append(notificationMode).append('\'');
        sb.append(", notificationParameters=").append(notificationParameters);
        sb.append(", notificationTemplateName='").append(notificationTemplateName).append('\'');
        sb.append('}');
        return sb.toString();
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

    public List<NotificationParameters> getNotificationParameters() {
        return notificationParameters;
    }

    public void setNotificationParameters(List<NotificationParameters> notificationParameters) {
        this.notificationParameters = notificationParameters;
    }

    public String getNotificationTemplateName() {
        return notificationTemplateName;
    }

    public void setNotificationTemplateName(String notificationTemplateName) {
        this.notificationTemplateName = notificationTemplateName;
    }
}
