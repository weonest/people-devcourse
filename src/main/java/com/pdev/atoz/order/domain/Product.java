package com.pdev.atoz.order.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Enumerated(EnumType.STRING)
    @Column(name = "Category", nullable = false)
    private Category category;

    @Column(name = "price", nullable = false)
    private long price;

    @Column(name = "description")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Builder
    public Product(String productName,
                   Category category,
                   long price,
                   String description,
                   LocalDateTime createdAt) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.description = description;
        this.createdAt = createdAt;
    }

    public void updateModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
