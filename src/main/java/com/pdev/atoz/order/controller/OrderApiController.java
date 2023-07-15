package com.pdev.atoz.order.controller;

import com.pdev.atoz.order.dto.OrderCreateDto;
import com.pdev.atoz.order.dto.OrderResponseDto;
import com.pdev.atoz.order.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/orders")
public class OrderApiController {

    private OrderService orderService;

    @PostMapping()
    public ResponseEntity<OrderResponseDto> createOrder(@Valid @RequestBody OrderCreateDto createDto) {
        OrderResponseDto response = orderService.create(createDto);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
