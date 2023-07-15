package com.pdev.atoz.order.dto;

import com.pdev.atoz.order.domain.Category;

public record ProductCreateDto(
        String productName,
        Category category,
        int price,
        String description
) {
}
