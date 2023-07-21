package com.pdev.atoz.product.dto;

import com.pdev.atoz.product.domain.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ProductUpdateDto (
        @NotBlank
        long productId,
        @NotBlank
        String productName,
        @NotBlank
        Category category,
        @Min(1)
        int price,
        String description
){
}
