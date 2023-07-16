package com.pdev.atoz.order.service;

import com.pdev.atoz.order.domain.OrderItem;
import com.pdev.atoz.order.domain.OrderStatus;
import com.pdev.atoz.order.dto.OrderCreateDto;
import com.pdev.atoz.order.dto.OrderResponseDto;
import com.pdev.atoz.product.domain.Category;
import com.pdev.atoz.product.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class OrderServiceImplTest {

    @TestConfiguration
    @ComponentScan("com.pdev.atoz.order")
    static class Config{
    }

    @Autowired
    private OrderService orderService;

    // 서비스 구현해서 연결하고 테스트 하자 
    // 영속성 저장이 안되서 연관을 맺은 것도 저장이 안되는 중
    Product pr = new Product("밥", Category.FOOD, 100, "good", LocalDateTime.now());
    Product pr2 = new Product("죽", Category.FOOD, 100, "good", LocalDateTime.now());

    OrderItem orderItem = OrderItem.builder()
            .product(pr)
            .quantity(3)
            .createdAt(LocalDateTime.now())
            .build();

    OrderItem orderItem2 = OrderItem.builder()
            .product(pr2)
            .quantity(5)
            .createdAt(LocalDateTime.now())
            .build();

    List<OrderItem> items = new ArrayList<>(List.of(orderItem, orderItem2));

    @DisplayName("사용자 요청 정보를 통해 주문을 생성할 수 있다.")
    @Test
    void createOrderTest() {
        OrderCreateDto createDto = new OrderCreateDto("건희", "수원", items);

        OrderResponseDto createdOrder = orderService.create(createDto);

        assertThat(createdOrder).isNotNull();
    }

    @DisplayName("주문 id를 통해 주문 상태를 취소로 변경할 수 있다.")
    @Test
    void cancelOrderTest() {
        OrderCreateDto createDto = new OrderCreateDto("건희", "수원", items);
        OrderResponseDto createdOrder = orderService.create(createDto);
        long orderId = createdOrder.orderId();

        orderService.cancelOrder(orderId);
        OrderResponseDto storedOrder = orderService.findOrder(orderId);

        assertThat(storedOrder.orderStatus()).isEqualTo(OrderStatus.CANCELLED.toString());
    }
}