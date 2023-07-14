package com.pdev.atoz.order.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Order {

    private final Email email;
    private final String address;
    private final OrderStatus orderStatus;
    private final LocalDateTime createdAt;
    private final List<OrderItem> orderItems;

    @Builder
    private Order(Email email,
                 String address,
                 OrderStatus orderStatus,
                 LocalDateTime createdAt,
                 List<OrderItem> orderItems) {
        this.email = email;
        this.address = address;
        this.orderItems = orderItems;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }

}
