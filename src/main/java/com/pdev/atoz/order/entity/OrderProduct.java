package com.pdev.atoz.order.entity;

import com.pdev.atoz.product.domain.Product;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "order_product")
@Entity
@Getter
@NoArgsConstructor
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String category;

    private int quantity;

    private int totalPrice;

    private LocalDateTime createdAt;

    @Builder
    private OrderProduct(Order order, Product product, String category, int quantity, int totalPrice, LocalDateTime createdAt) {
        this.order = order;
        this.product = product;
        this.category = category;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
    }
}
