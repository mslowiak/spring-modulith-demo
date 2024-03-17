package com.github.mslowiak.demo;

import java.util.List;
import java.util.UUID;

import com.github.mslowiak.demo.order.OrderApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration
class ExampleApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.from(Application::main)
                .with(ExampleApplication.class)
                .run(args)
                .getApplicationContext();

        var orders = ctx.getBean(OrderApi.class);

        orders.createOrder(
                UUID.randomUUID(),
                List.of(
                        "Coffee beans",
                        "Little bit of patience",
                        "Determination"
                )
        );
    }

}
