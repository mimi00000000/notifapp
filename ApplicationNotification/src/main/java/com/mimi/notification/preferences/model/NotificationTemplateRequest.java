package com.mimi.notification.preferences.model;


import com.mimi.notification.preferences.entities.NotificationParameters;

import java.util.List;

public class NotificationTemplateRequest {

    private List<NotificationParameters> notificationParameters;
    private String notificationTemplateName;
    private String notificationMode;

    public NotificationTemplateRequest() {
    }

    public NotificationTemplateRequest(List<NotificationParameters> notificationParameters, String notificationTemplateName, String notificationMode) {
        this.notificationParameters = notificationParameters;
        this.notificationTemplateName = notificationTemplateName;
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

    public String getNotificationMode() {
        return notificationMode;
    }

    public void setNotificationMode(String notificationMode) {
        this.notificationMode = notificationMode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationTemplateRequest{");
        sb.append("notificationParameters=").append(notificationParameters);
        sb.append(", notificationTemplateName='").append(notificationTemplateName).append('\'');
        sb.append(", notificationMode='").append(notificationMode).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
