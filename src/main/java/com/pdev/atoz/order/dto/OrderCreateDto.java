package com.pdev.atoz.order.dto;

import com.pdev.atoz.order.domain.OrderItem;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderCreateDto (
        @NotNull
        String email,
        @NotNull
        String address,
        @NotNull
        List<OrderItem> items
){
}
