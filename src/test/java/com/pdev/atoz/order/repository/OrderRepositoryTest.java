package com.pdev.atoz.order.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

//    @Test
//    void test() {
//        Email geonhee = new Email("geonhee");
//        Order order = new Order(geonhee, "gd", null, OrderStatus.READY_FOR_DELIVERY, null);
//        orderRepository.save(order);
//    }

}