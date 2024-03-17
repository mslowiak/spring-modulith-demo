package com.github.mslowiak.demo.notification.internal.application;

public interface ExternalNotificationPort {
    void send(String customerEmail, String notificationMessage);
}
