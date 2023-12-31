package com.pdev.atoz.product.dto;

import com.pdev.atoz.product.domain.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductCreateDto(
        @NotBlank
        String productName,
        @NotNull
        Category category,
        @Min(0)
        int price,
        String description
) {
}
