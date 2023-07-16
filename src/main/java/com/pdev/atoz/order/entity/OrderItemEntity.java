package com.pdev.atoz.order.entity;

import com.pdev.atoz.product.domain.Product;
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

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "order_id")
    private OrderEntity orderId;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product productId;

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
    private OrderItemEntity(@NotNull OrderEntity orderId, @NotNull Product productId, @NotNull String category, @NotNull int quantity, @NotNull LocalDateTime createdAT) {
        this.orderId = orderId;
        this.productId = productId;
        this.category = category;
        this.quantity = quantity;
        this.createdAT = createdAT;
    }
}
