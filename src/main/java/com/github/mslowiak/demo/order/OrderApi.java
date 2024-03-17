package com.github.mslowiak.demo.order;

import java.util.List;
import java.util.UUID;

public interface OrderApi {
    void createOrder(UUID customerId, List<String> items);
}
