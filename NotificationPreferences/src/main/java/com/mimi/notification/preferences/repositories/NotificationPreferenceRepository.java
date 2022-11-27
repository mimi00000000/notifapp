package com.mimi.notification.preferences.repositories;

import com.mimi.notification.preferences.entities.NotificationPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationPreferenceRepository extends JpaRepository<NotificationPreferences,Long> {
    NotificationPreferences findByCustomerid(String customerid);
}

