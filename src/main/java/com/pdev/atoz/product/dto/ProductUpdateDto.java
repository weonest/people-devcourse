package com.pdev.atoz.product.dto;

import com.pdev.atoz.product.domain.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ProductUpdateDto (
        @NotNull
        long productId,
        @NotEmpty
        String productName,
        @NotNull
        Category category,
        @Min(1)
        int price,
        String description
){
}
