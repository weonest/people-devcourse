package com.pdev.atoz.order.dto;

import java.time.LocalDateTime;

public record OrderResponseDto(
        long orderId,
        String email,
        String address,
        String orderStatus,
        LocalDateTime createdAt
){
}
