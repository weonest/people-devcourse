package com.pdev.atoz.order.repository;

import com.pdev.atoz.order.domain.*;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderItemRepositoryTest {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    EntityManager em;

    @Test
    void test() {
        Email geonhee = new Email("geonhee");
        OrderItem orderItem2 = new OrderItem(null, null, Category.FOOD, 3, LocalDateTime.now());
        List<OrderItem> list = new ArrayList<>(List.of(orderItem2));
        Order order = new Order(geonhee, "gd", list, OrderStatus.READY_FOR_DELIVERY, LocalDateTime.now());
        Product product = new Product("밥", Category.FOOD, 100, "good", LocalDateTime.now());
        OrderItem orderItem = new OrderItem(order, product, product.getCategory(), 3, LocalDateTime.now());
        orderItemRepository.save(orderItem);
    }
}