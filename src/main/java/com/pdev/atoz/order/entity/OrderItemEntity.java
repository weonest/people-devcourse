package com.pdev.atoz.order.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "order_item")
@Entity
@Getter
@NoArgsConstructor
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "order_id")
    private long orderId;

    @NotNull
    @Column(name = "product_id")
    private long productId;

    @NotNull
    @Column(name = "category")
    private String category;

    @NotNull
    @Column(name = "quantity")
    private int quantity;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAT;

    @Builder
    private OrderItemEntity(long id, @NotNull long orderId, @NotNull long productId, @NotNull String category, @NotNull int quantity, @NotNull LocalDateTime createdAT) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.category = category;
        this.quantity = quantity;
        this.createdAT = createdAT;
    }
}
