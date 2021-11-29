package com.manning.application.notification.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="NOTIFICATION")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerId;
    private String notificationMode;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<NotificationParameters> notificationParameters;
    private String notificationTemplateId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getNotificationMode() {
        return notificationMode;
    }

    public void setNotificationMode(String notificationMode) {
        this.notificationMode = notificationMode;
    }

    public List<NotificationParameters> getNotificationParameters() {
        return notificationParameters;
    }

    public void setNotificationParameters(List<NotificationParameters> notificationParameters) {
        this.notificationParameters = notificationParameters;
    }

    public String getNotificationTemplateId() {
        return notificationTemplateId;
    }

    public void setNotificationTemplateId(String notificationTemplateId) {
        this.notificationTemplateId = notificationTemplateId;
    }
}
