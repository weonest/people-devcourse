package com.pdev.atoz.order.entity;

import com.pdev.atoz.product.domain.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty
    @Column(name = "category")
    private String category;

    @NotEmpty
    @Column(name = "quantity")
    private int quantity;

    @NotEmpty
    @Column(name = "total_price")
    private int totalPrice;

    @NotEmpty
    @Column(name = "created_at")
    private LocalDateTime createdAT;

    @Builder
    private OrderItemEntity(@NotEmpty OrderEntity orderId, @NotEmpty Product productId, @NotEmpty String category, @NotEmpty int quantity, @NotEmpty int totalPrice, @NotEmpty LocalDateTime createdAT) {
        this.orderId = orderId;
        this.productId = productId;
        this.category = category;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.createdAT = createdAT;
    }
}
