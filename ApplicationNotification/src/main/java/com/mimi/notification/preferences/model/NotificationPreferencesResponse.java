package com.manning.application.notification.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationPreferencesResponse {

    private String status;
    private String statusDescription;
    private boolean smsPreferenceFlag;
    private boolean emailPreferenceFlag;
    private String emailAddress;
    private String phoneNumber;

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
