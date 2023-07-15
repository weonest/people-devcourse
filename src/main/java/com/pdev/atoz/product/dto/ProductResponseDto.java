package com.pdev.atoz.product.dto;

import java.time.LocalDateTime;

public record ProductResponseDto(
        String productName,
        String category,
        long price,
        String description,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt
){
}
