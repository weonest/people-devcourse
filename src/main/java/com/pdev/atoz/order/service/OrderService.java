package com.pdev.atoz.order.service;

import com.pdev.atoz.order.domain.Order;
import com.pdev.atoz.order.dto.OrderCreateDto;

public interface OrderService {
    Order create(OrderCreateDto createDto);
}
