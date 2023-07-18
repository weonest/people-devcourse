package com.pdev.atoz.product.dto;

import com.pdev.atoz.product.domain.Category;
import jakarta.validation.constraints.NotEmpty;

public record ProductUpdateDto (
        @NotEmpty
        long productId,
        @NotEmpty
        String productName,
        @NotEmpty
        Category category,
        @NotEmpty
        int price,
        @NotEmpty
        String description
){
}
