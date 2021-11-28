package com.mimi.notification.preferences.model;


import java.util.List;

public class NotificationTemplateRequest {

    private List<NotificationParameters> notificationParametersList;
    private String notificationTemplateName;
    private String notificationMode;

    public NotificationTemplateRequest() {
    }

    public List<NotificationParameters> getNotificationParameters() {
        return notificationParametersList;
    }

    public void setNotificationParameters(List<NotificationParameters> notificationParameters) {
        this.notificationParametersList = notificationParameters;
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
        sb.append("notificationParameters=").append(notificationParametersList);
        sb.append(", notificationTemplateName='").append(notificationTemplateName).append('\'');
        sb.append(", notificationMode='").append(notificationMode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
