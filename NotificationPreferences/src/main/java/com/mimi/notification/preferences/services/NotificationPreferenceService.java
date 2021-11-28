package com.mimi.notification.preferences.services;

import com.mimi.notification.preferences.entities.NotificationPreferences;
import com.mimi.notification.preferences.formatters.NotificationPreferencesFormatter;
import com.mimi.notification.preferences.model.NotificationPreferencesRequest;
import com.mimi.notification.preferences.model.NotificationPreferencesResponse;
import com.mimi.notification.preferences.repositories.NotificationPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class NotificationPreferenceService {

    @Autowired
    NotificationPreferenceRepository notificationPreferenceRepository;

    @Autowired
    NotificationPreferencesFormatter notificationPreferencesFormatter;


    public NotificationPreferencesResponse getNotificationPreferences(@RequestBody NotificationPreferencesRequest notificationPreferenceRequest) {
        NotificationPreferences notificationPreference = notificationPreferenceRepository.findByCustomerid(notificationPreferenceRequest.getCustomerId());
        NotificationPreferencesResponse notificationPreferencesResponse = notificationPreferencesFormatter.formatNotificationResponse(notificationPreference);
        return notificationPreferencesResponse;
    }


}
