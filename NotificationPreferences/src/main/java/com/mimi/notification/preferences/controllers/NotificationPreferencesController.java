package com.mimi.notification.preferences.controllers;


import com.mimi.notification.preferences.model.NotificationPreferencesRequest;
import com.mimi.notification.preferences.model.NotificationPreferencesResponse;
import com.mimi.notification.preferences.services.NotificationPreferenceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification/preferences")
@Api(value="NotificationPreferencesService", description="Operations pertaining to managing Customer Notification Preferences")
public class NotificationPreferencesController {

    @Autowired
    private NotificationPreferenceService notificationPreferenceService;

    @PostMapping
    @ApiOperation(value = "Get the Notification Preferences for a Customer", response = NotificationPreferencesResponse.class)
    public NotificationPreferencesResponse getNotificationPreferences(@RequestBody NotificationPreferencesRequest notificationPreferencesRequest) {
        NotificationPreferencesResponse notificationPreferencesResponse=notificationPreferenceService.getNotificationPreferences(notificationPreferencesRequest);
        return notificationPreferencesResponse;
    }

}
