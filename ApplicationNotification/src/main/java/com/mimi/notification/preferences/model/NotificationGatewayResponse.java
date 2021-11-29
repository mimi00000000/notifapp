package com.mimi.notification.preferences.model;

public class NotificationGatewayResponse {

    private String status;
    private String statusDescription;

    public NotificationGatewayResponse() {
    }

    public NotificationGatewayResponse(String status, String statusDescription) {
        this.status = status;
        this.statusDescription = statusDescription;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationGatewayResponse{");
        sb.append("status='").append(status).append('\'');
        sb.append(", statusDescription='").append(statusDescription).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
