package com.mimi.notification.preferences.model;


public class NotificationPreferencesResponse {

    private String customerId;
    private String status;
    private String statusDescription;
    private boolean smsPreferenceFlag;
    private boolean emailPreferenceFlag;
    private String emailAddress;
    private String phoneNumber;

    public NotificationPreferencesResponse() {
    }

    public NotificationPreferencesResponse(String customerId, String status, String statusDescription, boolean smsPreferenceFlag, boolean emailPreferenceFlag, String emailAddress, String phoneNumber) {
        this.customerId = customerId;
        this.status = status;
        this.statusDescription = statusDescription;
        this.smsPreferenceFlag = smsPreferenceFlag;
        this.emailPreferenceFlag = emailPreferenceFlag;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationPreferencesResponse{");
        sb.append("customerId='").append(customerId).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", statusDescription='").append(statusDescription).append('\'');
        sb.append(", smsPreferenceFlag=").append(smsPreferenceFlag);
        sb.append(", emailPreferenceFlag=").append(emailPreferenceFlag);
        sb.append(", emailAddress='").append(emailAddress).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public boolean isSmsPreferenceFlag() {
        return smsPreferenceFlag;
    }

    public void setSmsPreferenceFlag(boolean smsPreferenceFlag) {
        this.smsPreferenceFlag = smsPreferenceFlag;
    }

    public boolean isEmailPreferenceFlag() {
        return emailPreferenceFlag;
    }

    public void setEmailPreferenceFlag(boolean emailPreferenceFlag) {
        this.emailPreferenceFlag = emailPreferenceFlag;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
