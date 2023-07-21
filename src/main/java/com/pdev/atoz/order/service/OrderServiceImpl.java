package com.pdev.atoz.order.service;

import com.pdev.atoz.order.domain.OrderItems;
import com.pdev.atoz.order.domain.OrderMapper;
import com.pdev.atoz.order.dto.OrderCreateDto;
import com.pdev.atoz.order.dto.OrderResponseDto;
import com.pdev.atoz.order.entity.Order;
import com.pdev.atoz.order.entity.OrderItem;
import com.pdev.atoz.order.repository.OrderItemRepository;
import com.pdev.atoz.order.repository.OrderRepository;
import com.pdev.atoz.product.domain.Product;
import com.pdev.atoz.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;
    private ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public OrderResponseDto create(OrderCreateDto createDto) {
        Order order = OrderMapper.convertCreateToEntity(createDto);
        orderRepository.save(order);

        OrderItems orderItems = new OrderItems(){{addItem(createDto.items());}};
        orderItems.getItemList().forEach(item -> {
            Product product = productRepository.findById(item.getProductId()).orElseThrow();
            OrderItem orderItem = OrderItem.builder()
                    .orderId(order)
                    .productId(product)
                    .category(item.getCategory())
                    .quantity(item.getQuantity())
                    .totalPrice(item.getTotalPrice())
                    .createdAt(LocalDateTime.now())
                    .build();

            orderItemRepository.save(orderItem);
        });
        return OrderMapper.convertEntityToResponse(order);
    }

    @Transactional
    public void cancelOrder(long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.cancel();
    }

    @Transactional
    public OrderResponseDto deliverOrder(long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.deliver();
        return OrderMapper.convertEntityToResponse(order);
    }

    @Transactional
    public OrderResponseDto completeOrder(long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.complete();
        return OrderMapper.convertEntityToResponse(order);
    }

    public OrderResponseDto findOrder(long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        return OrderMapper.convertEntityToResponse(order);
    }

    public List<OrderResponseDto> findOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderMapper::convertEntityToResponse)
                .toList();
    }

    @Transactional
    public void deleteOrderById(long orderId) {
        orderItemRepository.deleteByOrderIdId(orderId);
        orderRepository.deleteById(orderId);
    }
}
