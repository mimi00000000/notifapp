package com.manning.application.notification.model;

public class NotificationResponse {

    private String status;
    private String statusDescription;
    private Long notificationReferenceId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public Long getNotificationReferenceId() {
        return notificationReferenceId;
    }

    public void setNotificationReferenceId(Long notificationReferenceId) {
        this.notificationReferenceId = notificationReferenceId;
    }
}
