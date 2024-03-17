package com.github.mslowiak.demo.order.internal.domain;

import java.util.List;
import java.util.UUID;

public record Order(UUID orderId, UUID customerId, List<String> items) {

    public static Order newOrder(UUID customerId,
                                 List<String> items) {
        return new Order(
                UUID.randomUUID(),
                customerId,
                items
        );
    }

}
