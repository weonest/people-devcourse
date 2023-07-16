package com.pdev.atoz.order.service;

import com.pdev.atoz.order.domain.Category;
import com.pdev.atoz.order.domain.OrderItem;
import com.pdev.atoz.order.dto.OrderCreateDto;
import com.pdev.atoz.order.repository.OrderItemRepository;
import com.pdev.atoz.product.domain.Product;
import com.pdev.atoz.product.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        Product pr = new Product("밥", Category.FOOD, 100, "good", LocalDateTime.now());
        productRepository.save(pr);
        Product pr2 = new Product("죽", Category.FOOD, 100, "good", LocalDateTime.now());
        productRepository.save(pr2);
    }

    @Test
    void createOrderTest() {
        Product product1 = productRepository.findById(1L).get();
        Product product2 = productRepository.findById(2L).get();

        OrderItem orderItem = OrderItem.builder()
                .product(product1)
                .category(product1.getCategory())
                .quantity(3)
                .price(product1.getPrice())
                .createdAt(LocalDateTime.now())
                .build();

        OrderItem orderItem2 = OrderItem.builder()
                .product(product2)
                .category(product2.getCategory())
                .quantity(5)
                .price(product2.getPrice())
                .createdAt(LocalDateTime.now())
                .build();

        List<OrderItem> items = new ArrayList<>(List.of(orderItem, orderItem2));

        OrderCreateDto createDto = new OrderCreateDto("건희", "수원", items);

        orderService.create(createDto);

//        orderService.cancelOrder(1);
        orderService.deliverOrder(1);
    }
}