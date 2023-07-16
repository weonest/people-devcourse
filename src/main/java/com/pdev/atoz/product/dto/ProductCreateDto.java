package com.pdev.atoz.product.dto;

import com.pdev.atoz.product.domain.Category;

public record ProductCreateDto(
        String productName,
        Category category,
        int price,
        String description
) {
}
