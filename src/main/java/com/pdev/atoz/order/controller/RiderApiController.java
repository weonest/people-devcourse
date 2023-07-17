package com.pdev.atoz.order.controller;

import com.pdev.atoz.order.dto.OrderResponseDto;
import com.pdev.atoz.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/riders")
public class RiderApiController {

    private OrderService orderService;

    public RiderApiController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{id}/deliver")
    public ResponseEntity<OrderResponseDto> orderDeliver(@PathVariable long id) {
        OrderResponseDto response = orderService.deliverOrder(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<OrderResponseDto> orderComplete(@PathVariable long id) {
        OrderResponseDto response = orderService.completeOrder(id);
        return ResponseEntity.ok(response);
    }
}
