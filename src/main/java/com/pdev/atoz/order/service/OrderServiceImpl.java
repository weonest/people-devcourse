package com.pdev.atoz.order.service;

import com.pdev.atoz.order.domain.Email;
import com.pdev.atoz.order.domain.Order;
import com.pdev.atoz.order.domain.OrderItems;
import com.pdev.atoz.order.domain.OrderMapper;
import com.pdev.atoz.order.dto.OrderCreateDto;
import com.pdev.atoz.order.dto.OrderResponseDto;
import com.pdev.atoz.order.entity.OrderEntity;
import com.pdev.atoz.order.entity.OrderItemEntity;
import com.pdev.atoz.order.repository.OrderItemRepository;
import com.pdev.atoz.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Transactional
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
                    .category(orderItem.getCategory().toString())
                    .quantity(orderItem.getQuantity())
                    .totalPrice(orderItem.getTotalPrice())
                    .createdAT(orderItem.getCreatedAt())
                    .build();

            orderItemRepository.save(orderItemEntity);
        });
        return OrderMapper.convertEntityToResponse(orderEntity);
    }

    @Transactional
    public void cancelOrder(long orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).get();
        Order order = OrderMapper.convertEntityToDomain(orderEntity);
        order.cancel();
        orderRepository.updateOrderStatus(order.getOrderStatus().toString(), orderEntity.getId());
    }

    @Transactional
    public OrderResponseDto deliverOrder(long orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).get();
        Order order = OrderMapper.convertEntityToDomain(orderEntity);
        order.deliver();
        orderRepository.updateOrderStatus(order.getOrderStatus().toString(), orderEntity.getId());
        return OrderMapper.convertDomainToResponse(order);
    }

    @Transactional
    public OrderResponseDto completeOrder(long orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).get();
        Order order = OrderMapper.convertEntityToDomain(orderEntity);
        order.complete();
        orderRepository.updateOrderStatus(order.getOrderStatus().toString(), orderEntity.getId());
        return OrderMapper.convertDomainToResponse(order);
    }

    public OrderResponseDto findOrder(long id) {
        OrderEntity orderEntity = orderRepository.findById(id).get();
        return OrderMapper.convertEntityToResponse(orderEntity);
    }

    public List<OrderResponseDto> findOrders() {
        List<OrderEntity> orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderMapper::convertEntityToResponse)
                .toList();
    }

    @Transactional
    public void deleteOrderById(long orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).get();
        orderItemRepository.deleteByOrderId(orderEntity);
        orderRepository.deleteById(orderId);
    }
}
