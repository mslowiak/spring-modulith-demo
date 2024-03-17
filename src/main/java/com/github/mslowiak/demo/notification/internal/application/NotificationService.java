package com.github.mslowiak.demo.notification.internal.application;

import java.util.UUID;

import com.github.mslowiak.demo.notification.NotificationSentEvent;
import com.github.mslowiak.demo.notification.internal.domain.OrderCreatedNotification;
import com.github.mslowiak.demo.notification.internal.domain.RecipientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {

    private final RecipientRepository recipientRepository;
    private final ExternalNotificationPort externalNotificationPort;
    private final ApplicationEventPublisher eventPublisher;

    void sendNotification(OrderCreatedNotification orderCreatedNotification) {
        final var recipientId = orderCreatedNotification.getRecipientId();
        final var customerEmail = getCustomerEmail(recipientId);
        final var notificationMessage = orderCreatedNotification.getNotificationMessage();
        externalNotificationPort.send(customerEmail, notificationMessage);

        final var orderCreated = new NotificationSentEvent(recipientId, customerEmail, "ORDER_CREATED");
        eventPublisher.publishEvent(orderCreated);
    }

    String getCustomerEmail(UUID recipientId) {
        return recipientRepository.findCustomerEmail(recipientId);
    }

}
