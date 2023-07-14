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

    private int totalPrice;

    private LocalDateTime createdAt;

    @Builder
    private OrderItem(Order order,
                      Product product,
                      Category category,
                      int quantity,
                      int price,
                      LocalDateTime createdAt) {
        this.order = order;
        this.product = product;
        this.category = category;
        this.quantity = quantity;
        this.totalPrice = product.getPrice() * quantity;
        this.createdAt = createdAt;
    }


}
