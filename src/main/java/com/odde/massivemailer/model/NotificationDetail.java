package com.odde.massivemailer.model;

public class NotificationDetail {
    private Long id;
    private String emailAddress;

    public Long getId() {
        return id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }
}