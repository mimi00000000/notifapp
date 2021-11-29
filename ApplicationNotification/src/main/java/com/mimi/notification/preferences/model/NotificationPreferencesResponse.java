package com.mimi.notification.preferences.model;

public class NotificationPreferencesResponse {

    private String status;
    private String statusDescription;
    private boolean smsPreferenceFlag;
    private boolean emailPreferenceFlag;
    private String emailAddress;
    private String phoneNumber;
    private String customerId;

    public NotificationPreferencesResponse() {
    }

    public NotificationPreferencesResponse(String status, String statusDescription, boolean smsPreferenceFlag, boolean emailPreferenceFlag, String emailAddress, String phoneNumber, String customerId) {
        this.status = status;
        this.statusDescription = statusDescription;
        this.smsPreferenceFlag = smsPreferenceFlag;
        this.emailPreferenceFlag = emailPreferenceFlag;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.customerId = customerId;
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

    @Override
    public String toString() {
        return "NotificationPreferencesResponse{" +
            "status='" + status + '\'' +
            ", statusDescription='" + statusDescription + '\'' +
            ", smsPreferenceFlag=" + smsPreferenceFlag +
            ", emailPreferenceFlag=" + emailPreferenceFlag +
            ", emailAddress='" + emailAddress + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            '}';
    }
}
