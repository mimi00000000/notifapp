package com.mimi.notification.preferences.model;


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
        final StringBuilder sb = new StringBuilder("NotificationPreferencesRequest{");
        sb.append("customerId='").append(customerId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
