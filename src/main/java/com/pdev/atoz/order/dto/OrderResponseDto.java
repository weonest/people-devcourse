package com.pdev.atoz.order.dto;

import java.time.LocalDateTime;

public record OrderResponseDto(
        long orderId,
        String address,
        String email,
        String orderStatus,
        LocalDateTime createdAt
){
}
