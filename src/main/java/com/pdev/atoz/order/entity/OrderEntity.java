package com.pdev.atoz.order.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "orders")
@Entity
@Getter
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "order_status")
    private String orderStatus;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    private OrderEntity(@NotNull String email, @NotNull String address, @NotNull String orderStatus, @NotNull LocalDateTime createdAt) {
        this.email = email;
        this.address = address;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }

}
