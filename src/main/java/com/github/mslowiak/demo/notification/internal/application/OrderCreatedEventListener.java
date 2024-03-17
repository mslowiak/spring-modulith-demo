package com.github.mslowiak.demo.notification.internal.application;

import com.github.mslowiak.demo.notification.internal.domain.OrderCreatedNotification;
import com.github.mslowiak.demo.order.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreatedEventListener {

    private final NotificationService notificationService;

    @TransactionalEventListener
    public void handleOrderCreated(OrderCreatedEvent orderCreatedEvent) {
        log.info("Handling order created event.");
        final var orderCreatedNotification = OrderCreatedNotification.of(
                orderCreatedEvent.customerId(),
                orderCreatedEvent.orderId(),
                orderCreatedEvent.items()
        );
        notificationService.sendNotification(orderCreatedNotification);
    }

}

