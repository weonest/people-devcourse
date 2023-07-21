package com.pdev.atoz.product.domain;

import com.pdev.atoz.product.dto.ProductUpdateDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    private Long id;

    @Column(unique = true)
    private String productName;

    @Enumerated(EnumType.STRING)
    private Category category;

    private int price;

    private String description;

    private LocalDateTime createdAt;

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

    public void changeProduct(ProductUpdateDto updateDto) {
        this.productName = updateDto.productName();
        this.category = updateDto.category();
        this.price = updateDto.price();
        this.description = updateDto.description();
        this.modifiedAt = LocalDateTime.now();
    }


}
