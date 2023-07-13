package com.pdev.atoz.order.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    private Email email;

    @Column(name = "address", nullable = false)
    private String address;

    @Transient
    private List<OrderItem> orderItems;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Builder
    public Order(Email email,
                 String address,
                 List<OrderItem> orderItems,
                 OrderStatus orderStatus,
                 LocalDateTime createdAt) {
        this.email = email;
        this.address = address;
        this.orderItems = orderItems;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }

}
