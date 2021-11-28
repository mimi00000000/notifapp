package com.mimi.notification.preferences.model;

public class NotificationParameters {

    private String notificationParameterName;
    private String notificationParameterValue;

    public NotificationParameters() {
    }

    public NotificationParameters(String notificationParameterName, String notificationParameterValue) {
        this.notificationParameterName = notificationParameterName;
        this.notificationParameterValue = notificationParameterValue;
    }

    public String getNotificationParameterName() {
        return notificationParameterName;
    }

    public void setNotificationParameterName(String notificationParameterName) {
        this.notificationParameterName = notificationParameterName;
    }

    public String getNotificationParameterValue() {
        return notificationParameterValue;
    }

    public void setNotificationParameterValue(String notificationParameterValue) {
        this.notificationParameterValue = notificationParameterValue;
    }
}
