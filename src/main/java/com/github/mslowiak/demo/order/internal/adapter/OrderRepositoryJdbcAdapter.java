package com.github.mslowiak.demo.order.internal.adapter;

import com.github.mslowiak.demo.order.internal.domain.Order;
import com.github.mslowiak.demo.order.internal.domain.OrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryJdbcAdapter implements OrderRepository {

    @Override
    public void save(Order order) {

    }

}
