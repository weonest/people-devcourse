package com.pdev.atoz.order.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Order {

    private final Email email;
    private final String address;
    private OrderStatus orderStatus;
    private final LocalDateTime createdAt;

    @Builder
    private Order(Email email,
                 String address,
                 OrderStatus orderStatus,
                 LocalDateTime createdAt) {
        this.email = email;
        this.address = address;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }

    public void cancel() {
        this.orderStatus = OrderStatus.CANCELLED;
    }
}
