package com.github.mslowiak.demo.notification.internal.adapter;

import com.github.mslowiak.demo.notification.internal.application.ExternalNotificationPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExternalNotificationSystemAdapter implements ExternalNotificationPort {

    @Override
    public void send(String customerEmail, String notificationMessage) {
        log.info("Sending notification to customer: {}", customerEmail);
        log.info(notificationMessage);
    }

}
