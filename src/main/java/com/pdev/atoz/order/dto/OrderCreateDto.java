package com.pdev.atoz.order.dto;

import com.pdev.atoz.order.domain.OrderedItem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record OrderCreateDto (
        @NotBlank
        String email,
        @NotBlank
        String address,
        @NotBlank
        List<OrderedItem> items
){
}
