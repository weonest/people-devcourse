package com.pdev.atoz.order.service;

import com.pdev.atoz.order.dto.OrderCreateDto;
import com.pdev.atoz.order.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {
    OrderResponseDto create(OrderCreateDto createDto);

    void cancelOrder(long orderId);

    OrderResponseDto deliverOrder(long orderId);

    OrderResponseDto completeOrder(long orderId);

    List<OrderResponseDto> findOrders();

    OrderResponseDto findOrder(long id);

    void deleteOrderById(long id);

    List<OrderResponseDto> findOrderByUserId(long userId);

}
