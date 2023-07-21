package com.pdev.atoz.order.entity;

import com.pdev.atoz.order.domain.Email;
import com.pdev.atoz.order.domain.OrderStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "orders")
@Entity
@Getter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Email email;

    private String address;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDateTime createdAt;

    @Builder
    private Order(String email, String address, OrderStatus orderStatus, LocalDateTime createdAt) {
        this.email = new Email(email);
        this.address = address;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }

    public void cancel() {
        this.orderStatus = OrderStatus.CANCELLED;
    }

    public void deliver() {
        this.orderStatus = OrderStatus.DELIVERING;
    }

    public void complete() {
        this.orderStatus = OrderStatus.COMPLETED;
    }

}
