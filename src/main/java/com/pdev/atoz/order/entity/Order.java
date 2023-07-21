package com.pdev.atoz.order.entity;

import com.pdev.atoz.order.domain.Email;
import com.pdev.atoz.order.domain.OrderStatus;
import com.pdev.atoz.user.domain.User;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Email email;

    private String address;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDateTime createdAt;

    @Builder
    private Order(User user, String email, String address, OrderStatus orderStatus, LocalDateTime createdAt) {
        this.user = user;
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
