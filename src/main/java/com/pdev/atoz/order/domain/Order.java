package com.pdev.atoz.order.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Order {
    private final long id;
    private final Email email;
    private final String address;
    private OrderStatus orderStatus;
    private final LocalDateTime createdAt;

    @Builder
    private Order(long id,
                  Email email,
                  String address,
                  OrderStatus orderStatus,
                  LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.address = address;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }

    public void cancel() {
        this.orderStatus = OrderStatus.CANCELLED;
    }

    public void deliver() {
        this.orderStatus = OrderStatus.DELIVERING;
    }

    public void complete() {
        this.orderStatus = OrderStatus.COMPLETED;
    }
}
