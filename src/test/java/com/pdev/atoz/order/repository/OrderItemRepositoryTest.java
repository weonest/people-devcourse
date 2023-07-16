package com.pdev.atoz.order.repository;

import com.pdev.atoz.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderItemRepositoryTest {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    //containsExactly
//    @ParameterizedTest(name = "move 메서드는 값을 입력받아 4이상인 경우 전진한다. 초기 위치: 0 입력값: {0} 동작 후 위치: {1}")
//    @CsvSource(value = {"4,1", "3,0"})
//    @Test
//    void test() {
//        Email geonhee = new Email("geonhee");
//        Order order = new Order(geonhee, "gd", null, OrderStatus.READY_FOR_DELIVERY, LocalDateTime.now());
//        orderRepository.save(order);
//
//        Product product = new Product("밥", Category.FOOD, 100, "good", LocalDateTime.now());
//        productRepository.save(product);
//
//        OrderItem orderItem = new OrderItem(order, product, product.getCategory(), 3, LocalDateTime.now());
//        orderItemRepository.save(orderItem);
//    }
}