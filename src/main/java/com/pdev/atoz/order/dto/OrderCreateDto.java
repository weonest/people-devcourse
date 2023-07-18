package com.pdev.atoz.order.dto;

import com.pdev.atoz.order.domain.OrderItem;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record OrderCreateDto (
        @NotEmpty
        String email,
        @NotEmpty
        String address,
        @NotEmpty
        List<OrderItem> items
){
}
