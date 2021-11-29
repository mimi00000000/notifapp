package com.mimi.notification.preferences.model;

public class NotificationResponse {

    private String status;
    private String statusDescription;
    private Long notificationReferenceId;

    public NotificationResponse() {
    }

    public NotificationResponse(String status, String statusDescription, Long notificationReferenceId) {
        this.status = status;
        this.statusDescription = statusDescription;
        this.notificationReferenceId = notificationReferenceId;
    }

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
