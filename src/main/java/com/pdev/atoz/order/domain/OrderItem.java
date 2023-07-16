package com.pdev.atoz.order.domain;

import com.pdev.atoz.product.domain.Category;
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
                      int quantity,
                      LocalDateTime createdAt) {
        this.product = product;
        this.category = product.getCategory();
        this.quantity = quantity;
        this.totalPrice = product.getPrice() * quantity;
        this.createdAt = createdAt;
    }
}
