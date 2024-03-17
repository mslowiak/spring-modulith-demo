package com.github.mslowiak.demo.order;

import java.util.List;
import java.util.UUID;

public record OrderCreatedEvent(UUID orderId, UUID customerId, List<String> items) {
}
