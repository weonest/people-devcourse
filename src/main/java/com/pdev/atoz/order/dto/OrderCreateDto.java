package com.pdev.atoz.order.dto;

import com.pdev.atoz.order.domain.OrderedProduct;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderCreateDto (
        @NotBlank
        String email,
        @NotBlank
        String address,
        @NotNull
        List<OrderedProduct> items


){
}
