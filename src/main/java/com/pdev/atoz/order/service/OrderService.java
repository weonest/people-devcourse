package com.pdev.atoz.order.service;

import com.pdev.atoz.order.dto.OrderCreateDto;
import com.pdev.atoz.order.dto.OrderResponseDto;

public interface OrderService {
    OrderResponseDto create(OrderCreateDto createDto);

    void cancelOrder(long orderId);

    OrderResponseDto deliverOrder(long orderId);

    void deleteOrderById(long id);
}
