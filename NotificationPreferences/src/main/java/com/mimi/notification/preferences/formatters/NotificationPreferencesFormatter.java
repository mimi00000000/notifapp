package com.mimi.notification.preferences.formatters;

import com.mimi.notification.preferences.entities.NotificationPreferences;
import com.mimi.notification.preferences.model.NotificationPreferencesResponse;
import org.springframework.stereotype.Component;

@Component
public class NotificationPreferencesFormatter {


    public NotificationPreferencesResponse formatNotificationResponse(NotificationPreferences notificationPreference) {
        NotificationPreferencesResponse notificationPreferencesResponse=new NotificationPreferencesResponse();
        if(notificationPreference!=null && notificationPreference.getId()!= null) {
            notificationPreferencesResponse.setCustomerId(notificationPreference.getCustomerid());
            notificationPreferencesResponse.setEmailPreferenceFlag(notificationPreference.isEmailpreferenceflag());
            notificationPreferencesResponse.setSmsPreferenceFlag(notificationPreference.isSmspreferenceflag());
            notificationPreferencesResponse.setEmailAddress(notificationPreference.getEmailaddress());
            notificationPreferencesResponse.setPhoneNumber(notificationPreference.getPhonenumber());
            notificationPreferencesResponse.setStatus("SUCCESS");
            notificationPreferencesResponse.setStatusDescription("Notification Received Successfully");
        }
        else
        {
            notificationPreferencesResponse.setStatus("ERROR");
            notificationPreferencesResponse.setStatusDescription("Notification Failed");
        }
        return  notificationPreferencesResponse;

    }
}
