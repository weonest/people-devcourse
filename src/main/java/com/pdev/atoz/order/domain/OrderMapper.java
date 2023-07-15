package com.pdev.atoz.order.domain;

import com.pdev.atoz.order.dto.OrderCreateDto;
import com.pdev.atoz.order.dto.OrderResponseDto;
import com.pdev.atoz.order.entity.OrderEntity;
import com.pdev.atoz.order.entity.OrderItemEntity;

import java.time.LocalDateTime;

public class OrderMapper {

    private OrderMapper() {
    }

    public static OrderEntity convertCreateToEntity(OrderCreateDto createDto, Email email) {
        return OrderEntity.builder()
                .email(email.getMailAddress())
                .address(createDto.address())
                .orderStatus(OrderStatus.READY_FOR_DELIVERY.toString())
                .createdAt(LocalDateTime.now())
                .build();
    }

    //    public static OrderItemEntity convertOrderItemToEntity(OrderItem orderItem) {
//        return OrderItemEntity.builder()
//                .orderId(orderEntity)
//                .productId(orderItem.getProduct())
//                .orderStatus(orderEntity.getOrderStatus())
//                .quantity(orderItem.getQuantity())
//                .createdAT(orderItem.getCreatedAt())
//                .build();
//    }
    public static OrderResponseDto convertEntityToResponse(OrderEntity orderEntity) {
        return new OrderResponseDto(orderEntity.getId(),
                orderEntity.getEmail(),
                orderEntity.getAddress(),
                orderEntity.getOrderStatus(),
                orderEntity.getCreatedAt());
    }
}
