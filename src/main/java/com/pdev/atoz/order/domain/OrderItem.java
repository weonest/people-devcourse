package com.pdev.atoz.order.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderItem {

    private long productId;

    private Category category;

    private int quantity;

    private int totalPrice;

    private LocalDateTime createdAt;

    @Builder
    private OrderItem(long productId,
                      Category category,
                      int quantity,
                      int price,
                      LocalDateTime createdAt) {
        this.productId = productId;
        this.category = category;
        this.quantity = quantity;
        this.totalPrice = price * quantity;
        this.createdAt = createdAt;
    }

}
