package com.pdev.atoz.order.service;

import com.pdev.atoz.order.domain.OrderItem;
import com.pdev.atoz.order.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {
    OrderResponseDto create(String mailAddress, String address, List<OrderItem> items);
}
