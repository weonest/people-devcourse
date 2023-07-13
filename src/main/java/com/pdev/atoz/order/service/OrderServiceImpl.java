package com.pdev.atoz.order.service;

import com.pdev.atoz.order.domain.Email;
import com.pdev.atoz.order.domain.Order;
import com.pdev.atoz.order.dto.OrderCreateDto;
import com.pdev.atoz.order.domain.OrderStatus;
import com.pdev.atoz.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(OrderCreateDto createDto) {
        Email email = new Email(createDto.email());
        Order order = new Order(
                email,
                createDto.address(),
                createDto.orderItems(),
                OrderStatus.READY_FOR_DELIVERY,
                LocalDateTime.now()
        );
        return orderRepository.save(order);
    }
}
