package com.pdev.atoz.order.service;

import com.pdev.atoz.order.domain.*;
import com.pdev.atoz.order.dto.OrderResponseDto;
import com.pdev.atoz.order.entity.OrderEntity;
import com.pdev.atoz.order.entity.OrderItemEntity;
import com.pdev.atoz.order.repository.OrderItemRepository;
import com.pdev.atoz.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderResponseDto create(String mailAddress, String address, List<OrderItem> items) {
        Email email = new Email(mailAddress);

        OrderEntity orderEntity = OrderEntity.builder()
                .email(email.getMailAddress())
                .address(address)
                .orderStatus(OrderStatus.READY_FOR_DELIVERY.toString())
                .createdAt(LocalDateTime.now())
                .build();
        orderRepository.save(orderEntity);

        OrderItems orderItems = new OrderItems();
        orderItems.addItem(items);
        orderItems.getOrderItemList().forEach(orderItem -> {
            OrderItemEntity orderItemEntity = OrderItemEntity.builder()
                    .orderId(orderEntity)
                    .productId(orderItem.getProduct())
                    .orderStatus(orderEntity.getOrderStatus())
                    .quantity(orderItem.getQuantity())
                    .createdAT(orderItem.getCreatedAt())
                    .build();
            orderItemRepository.save(orderItemEntity);
        });
        return null;
    }
}
