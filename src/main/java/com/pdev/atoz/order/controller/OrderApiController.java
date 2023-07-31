package com.pdev.atoz.order.controller;

import com.pdev.atoz.order.dto.OrderCreateDto;
import com.pdev.atoz.order.dto.OrderResponseDto;
import com.pdev.atoz.order.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/orders")
public class OrderApiController {

    private OrderService orderService;

    public OrderApiController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public ResponseEntity<List<OrderResponseDto>> orderList() {
        List<OrderResponseDto> response = orderService.findOrders();
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<OrderResponseDto> orderCreate(@Valid @RequestBody OrderCreateDto createDto) {
        OrderResponseDto response = orderService.create(createDto);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> orderDelete(@PathVariable Long id) {
        orderService.deleteOrderById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> orderCancel(@PathVariable Long id) {
        orderService.cancelOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
