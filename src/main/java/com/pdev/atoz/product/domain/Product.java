package com.pdev.atoz.product.domain;

import com.pdev.atoz.order.domain.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Column(name = "product_name")
    private String productName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "Category")
    private Category category;

    @NotNull
    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Builder
    public Product(String productName,
                   Category category,
                   int price,
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
