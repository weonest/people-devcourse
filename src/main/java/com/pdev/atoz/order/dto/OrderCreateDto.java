package com.pdev.atoz.order.dto;

import com.pdev.atoz.order.domain.OrderItem;

import java.util.List;

public record OrderCreateDto (
        String email,
        String address,
        List<OrderItem> orderItems
){
}
