package com.mimi.notification.preferences.repositories;

import com.mimi.notification.preferences.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    Notification save(Notification notification);
}

