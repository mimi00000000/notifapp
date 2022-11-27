package com.mimi.notification.preferences.entities;

import javax.persistence.*;

@Entity
@Table(name="NOTIFICATION_PREFERENCES")
public class NotificationPreferences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerid;
    private boolean smspreferenceflag;
    private boolean emailpreferenceflag;
    private String emailaddress;
    private String phonenumber;

    public NotificationPreferences() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public boolean isSmspreferenceflag() {
        return smspreferenceflag;
    }

    public void setSmspreferenceflag(boolean smspreferenceflag) {
        this.smspreferenceflag = smspreferenceflag;
    }

    public boolean isEmailpreferenceflag() {
        return emailpreferenceflag;
    }

    public void setEmailpreferenceflag(boolean emailpreferenceflag) {
        this.emailpreferenceflag = emailpreferenceflag;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
