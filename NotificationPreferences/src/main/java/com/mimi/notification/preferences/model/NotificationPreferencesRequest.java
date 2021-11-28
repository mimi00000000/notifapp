package com.mimi.notification.preferences.model;


import java.util.List;

public class NotificationPreferencesRequest {

    private String customerId;

    public NotificationPreferencesRequest() {
    }

    public NotificationPreferencesRequest(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "NotificationPreferencesRequest{" +
            "customerId='" + customerId + '\'' +
            '}';
    }
}
