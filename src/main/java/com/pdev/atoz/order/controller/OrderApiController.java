package com.pdev.atoz.order.controller;

import com.pdev.atoz.order.dto.OrderCreateDto;
import com.pdev.atoz.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/orders")
public class OrderApiController {

    private OrderService orderService;

    @PostMapping()
    public ResponseEntity<Void> createOrder(@RequestBody OrderCreateDto createDto) {
        orderService.create(createDto.address(), createDto.address(), createDto.items());
        return null;
    }
}
