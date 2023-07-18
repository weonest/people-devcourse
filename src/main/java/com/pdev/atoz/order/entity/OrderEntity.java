package com.pdev.atoz.order.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty
    @Column(name = "address")
    private String address;

    @NotEmpty
    @Column(name = "order_status")
    private String orderStatus;

    @NotEmpty
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    private OrderEntity(@NotEmpty String email, @NotEmpty String address, @NotEmpty String orderStatus, @NotEmpty LocalDateTime createdAt) {
        this.email = email;
        this.address = address;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }

}
