package com.pdev.atoz.order.domain;

import com.pdev.atoz.order.dto.OrderCreateDto;
import com.pdev.atoz.order.dto.OrderResponseDto;
import com.pdev.atoz.order.entity.Order;
import com.pdev.atoz.user.domain.User;

import java.time.LocalDateTime;

public class OrderMapper {

    private OrderMapper() {
    }

    public static Order convertCreateToEntity(OrderCreateDto createDto, User user) {
        return Order.builder()
                .user(user)
                .email(createDto.email())
                .address(createDto.address())
                .orderStatus(OrderStatus.READY_FOR_DELIVERY)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static OrderResponseDto convertEntityToResponse(Order order) {
        return new OrderResponseDto(order.getId(),
                order.getEmail().getMailAddress(),
                order.getAddress(),
                order.getOrderStatus().toString(),
                order.getCreatedAt());
    }

}
