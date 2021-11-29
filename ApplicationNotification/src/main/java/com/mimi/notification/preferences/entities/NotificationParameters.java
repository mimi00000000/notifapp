package com.mimi.notification.preferences.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NotificationParameters {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String notificationParameterName;
    private String notificationParameterValue;

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
