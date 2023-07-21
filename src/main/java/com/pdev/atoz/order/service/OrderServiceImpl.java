package com.pdev.atoz.order.service;

import com.pdev.atoz.order.domain.OrderProducts;
import com.pdev.atoz.order.domain.OrderMapper;
import com.pdev.atoz.order.dto.OrderCreateDto;
import com.pdev.atoz.order.dto.OrderResponseDto;
import com.pdev.atoz.order.entity.Order;
import com.pdev.atoz.order.entity.OrderProduct;
import com.pdev.atoz.order.repository.OrderProductRepository;
import com.pdev.atoz.order.repository.OrderRepository;
import com.pdev.atoz.product.domain.Product;
import com.pdev.atoz.product.repository.ProductRepository;
import com.pdev.atoz.user.domain.User;
import com.pdev.atoz.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderProductRepository orderProductRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public OrderResponseDto create(OrderCreateDto createDto) {
        User user = userRepository.findByEmailMailAddress(createDto.email()).orElseThrow();

        Order order = OrderMapper.convertCreateToEntity(createDto, user);
        orderRepository.save(order);

        OrderProducts orderProducts = new OrderProducts(){{addItem(createDto.items());}};
        orderProducts.getItemList().forEach(item -> {
            Product product = productRepository.findById(item.getProductId()).orElseThrow();
            OrderProduct orderProduct = OrderProduct.builder()
                    .order(order)
                    .product(product)
                    .category(item.getCategory())
                    .quantity(item.getQuantity())
                    .totalPrice(item.getTotalPrice())
                    .createdAt(LocalDateTime.now())
                    .build();

            orderProductRepository.save(orderProduct);
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

    public List<OrderResponseDto> findOrderByUserId(long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders.stream()
                .map(OrderMapper::convertEntityToResponse)
                .toList();
    }

    public List<OrderResponseDto> findOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderMapper::convertEntityToResponse)
                .toList();
    }

    @Transactional
    public void deleteOrderById(long orderId) {
        orderProductRepository.deleteByOrderId(orderId);
        orderRepository.deleteById(orderId);
    }
}
