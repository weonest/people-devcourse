package com.pdev.atoz.order.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record OrderCreateDto (
        @NotEmpty
        String email,
        @NotEmpty
        String address,
        @NotEmpty
        List<OrderItemCreateDto> items
){
}
