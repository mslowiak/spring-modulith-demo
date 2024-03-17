package com.github.mslowiak.demo.order.internal.application;

import java.util.List;
import java.util.UUID;

import com.github.mslowiak.demo.order.OrderApi;
import com.github.mslowiak.demo.order.OrderCreatedEvent;
import com.github.mslowiak.demo.order.internal.domain.Order;
import com.github.mslowiak.demo.order.internal.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderApi {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void createOrder(UUID customerId, List<String> items) {
        final var order = Order.newOrder(customerId, items);
        final var orderCreated = new OrderCreatedEvent(order.orderId(), customerId, items);

        orderRepository.save(order);
        applicationEventPublisher.publishEvent(orderCreated);
    }

}
