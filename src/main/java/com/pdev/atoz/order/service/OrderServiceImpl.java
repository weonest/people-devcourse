package com.pdev.atoz.order.service;

import com.pdev.atoz.order.domain.*;
import com.pdev.atoz.order.dto.OrderCreateDto;
import com.pdev.atoz.order.dto.OrderResponseDto;
import com.pdev.atoz.order.entity.OrderEntity;
import com.pdev.atoz.order.entity.OrderItemEntity;
import com.pdev.atoz.order.repository.OrderItemRepository;
import com.pdev.atoz.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderResponseDto create(OrderCreateDto createDto) {
        Email email = new Email(createDto.email());
        OrderEntity orderEntity = OrderMapper.convertCreateToEntity(createDto, email);
        orderRepository.save(orderEntity);

        OrderItems orderItems = new OrderItems(){{addItem(createDto.items());}};
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
        return OrderMapper.convertEntityToResponse(orderEntity);
    }
}
