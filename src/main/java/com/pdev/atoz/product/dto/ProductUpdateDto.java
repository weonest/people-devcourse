package com.pdev.atoz.product.dto;

import com.pdev.atoz.product.domain.Category;
import jakarta.validation.constraints.NotNull;

public record ProductUpdateDto (
        @NotNull
        long productId,
        @NotNull
        String productName,
        @NotNull
        Category category,
        @NotNull
        int price,
        @NotNull
        String description
){
}
