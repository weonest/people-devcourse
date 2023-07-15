package com.pdev.atoz.order.domain;

import com.pdev.atoz.product.domain.Product;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderItem {

    private Product product;

    private Category category;

    private int quantity;

    private int totalPrice;

    private LocalDateTime createdAt;

    @Builder
    private OrderItem(Product product,
                      Category category,
                      int quantity,
                      int price,
                      LocalDateTime createdAt) {
        this.product = product;
        this.category = category;
        this.quantity = quantity;
        this.totalPrice = price * quantity;
        this.createdAt = createdAt;
    }

}
