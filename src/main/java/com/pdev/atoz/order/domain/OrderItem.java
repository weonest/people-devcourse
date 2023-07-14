package com.pdev.atoz.order.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderItem {

    private Order order;

    private Product product;

    private Category category;

    private int quantity;

    private LocalDateTime createdAt;

    @Builder
    private OrderItem(Order order,
                     Product product,
                     Category category,
                     int quantity,
                     LocalDateTime createdAt) {
        this.order = order;
        this.product = product;
        this.category = category;
        this.quantity = quantity;
        this.createdAt = createdAt;
    }


}
