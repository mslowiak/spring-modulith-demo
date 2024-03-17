package com.github.mslowiak.demo.notification.internal.domain;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import lombok.Value;

@Value(staticConstructor = "of")
public class OrderCreatedNotification {

    UUID recipientId;
    UUID orderId;
    List<String> orderedItems;

    public String getNotificationMessage() {
        final var items = orderedItems.stream().map(item -> "- " + item).collect(Collectors.joining("\n"));
        return String.format("""
                
                ======= NOTIFICATION START ========
                Dear customer!
                
                We received your order with the following number: %s.
                
                List of bought items:
                %s
                
                ======= NOTIFICATION END ========
                """,
                orderId,
                items
        );
    }

}
