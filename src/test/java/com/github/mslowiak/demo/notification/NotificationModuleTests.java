package com.github.mslowiak.demo.notification;

import java.util.List;
import java.util.UUID;

import com.github.mslowiak.demo.order.OrderCreatedEvent;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

@ApplicationModuleTest //  Bootstrap Modes
class NotificationModuleTests {

    @Test
    void bootstrapsNotificationModule() {

    }

    @Test
    void onceReceivingOrderCreatedEventTheNotificationIsSent(Scenario scenario) {
        // given
        final var orderCreatedEvent = new OrderCreatedEvent(
                UUID.randomUUID(),
                UUID.randomUUID(),
                List.of("Apple", "Pillow")

        );

        // when & then
        scenario.publish(orderCreatedEvent)
                .andWaitForEventOfType(NotificationSentEvent.class)
                .matchingMappedValue(NotificationSentEvent::recipientId, orderCreatedEvent.customerId())
                .matchingMappedValue(NotificationSentEvent::notificationType, "ORDER_CREATED")
                .matchingMappedValue(NotificationSentEvent::email, "test@gmail.com")
                .toArrive();
    }

}
