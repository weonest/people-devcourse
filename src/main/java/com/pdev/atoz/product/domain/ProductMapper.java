package com.pdev.atoz.product.domain;

import com.pdev.atoz.product.dto.ProductCreateDto;
import com.pdev.atoz.product.dto.ProductResponseDto;

import java.time.LocalDateTime;

public class ProductMapper {

    private ProductMapper() {
    }

    public static Product convertCreateToEntity(ProductCreateDto createDto, LocalDateTime createdAt) {
        return Product.builder()
                .productName(createDto.productName())
                .category(createDto.category())
                .price(createDto.price())
                .description(createDto.description())
                .createdAt(createdAt)
                .build();
    }

    public static ProductResponseDto convertEntityToResponse(Product product) {
        return new ProductResponseDto(product.getId(),
                product.getProductName(),
                product.getCategory().toString(),
                product.getPrice(),
                product.getDescription(),
                product.getCreatedAt(),
                product.getModifiedAt());
    }
}
