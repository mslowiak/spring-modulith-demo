package com.github.mslowiak.demo.order.internal.application;

import java.util.List;
import java.util.UUID;

import com.github.mslowiak.demo.notification.internal.application.NotificationService;
import com.github.mslowiak.demo.notification.internal.domain.OrderCreatedNotification;
import com.github.mslowiak.demo.order.OrderApi;
import com.github.mslowiak.demo.order.internal.domain.Order;
import com.github.mslowiak.demo.order.internal.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService implements OrderApi {

    private final OrderRepository orderRepository;
    private final NotificationService notificationService;

    @Transactional
    public void createOrder(UUID customerId, List<String> items) {
        final var order = Order.newOrder(customerId, items);

        orderRepository.save(order);
        sendNotification(order);
    }

    private void sendNotification(Order order) {
        log.info("Handling order created event.");
        final var orderCreatedNotification = OrderCreatedNotification.of(
                order.customerId(),
                order.orderId(),
                order.items()
        );
        notificationService.sendNotification(orderCreatedNotification);
    }

}
