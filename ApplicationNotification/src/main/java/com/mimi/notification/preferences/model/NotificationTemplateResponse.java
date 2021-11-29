package com.mimi.notification.preferences.model;

public class NotificationTemplateResponse {

    private String status;
    private String statusDescription;
    private String emailContent;
    private String smsContent;
    private String emailSubject;

    public NotificationTemplateResponse() {
    }

    public NotificationTemplateResponse(String status, String statusDescription, String emailContent, String smsContent, String emailSubject) {
        this.status = status;
        this.statusDescription = statusDescription;
        this.emailContent = emailContent;
        this.smsContent = smsContent;
        this.emailSubject = emailSubject;
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

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationTemplateResponse{");
        sb.append("status='").append(status).append('\'');
        sb.append(", statusDescription='").append(statusDescription).append('\'');
        sb.append(", emailContent='").append(emailContent).append('\'');
        sb.append(", smsContent='").append(smsContent).append('\'');
        sb.append(", emailSubject='").append(emailSubject).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
