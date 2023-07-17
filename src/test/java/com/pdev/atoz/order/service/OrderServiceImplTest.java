package com.pdev.atoz.order.service;

import com.pdev.atoz.order.domain.OrderItem;
import com.pdev.atoz.order.domain.OrderStatus;
import com.pdev.atoz.order.dto.OrderCreateDto;
import com.pdev.atoz.order.dto.OrderResponseDto;
import com.pdev.atoz.product.domain.Category;
import com.pdev.atoz.product.domain.Product;
import com.pdev.atoz.product.repository.ProductRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductRepository productRepository;

    private List<OrderItem> items;

    @BeforeAll
    void setUp() {
        Product pr = new Product("밥", Category.FOOD, 100, "good", LocalDateTime.now());
        productRepository.save(pr);
        Product pr2 = new Product("죽", Category.FOOD, 100, "good", LocalDateTime.now());
        productRepository.save(pr2);

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

        items = new ArrayList<>(List.of(orderItem, orderItem2));
    }

    @DisplayName("사용자 요청 정보를 통해 주문을 생성할 수 있다.")
    @Test
    void createOrderTest() {
        OrderCreateDto createDto = new OrderCreateDto("건희", "수원", items);

        OrderResponseDto createdOrder = orderService.create(createDto);

        assertThat(createdOrder).isNotNull();
    }

    @DisplayName("주문 Id를 통해 주문을 취소할 수 있다.")
    @Test
    void cancelOrderTest() {
        OrderCreateDto createDto = new OrderCreateDto("건희", "수원", items);
        OrderResponseDto createdOrder = orderService.create(createDto);
        long id = createdOrder.orderId();

        orderService.cancelOrder(id);
        OrderResponseDto canceledOrder = orderService.findOrder(id);

        assertThat(canceledOrder.orderStatus()).isEqualTo(OrderStatus.CANCELLED.toString());
    }

    @DisplayName("주문 Id를 통해 주문을 배달할 수 있다.")
    @Test
    void deliverOrderTest() {
        OrderCreateDto createDto = new OrderCreateDto("건희", "수원", items);
        OrderResponseDto createdOrder = orderService.create(createDto);
        long id = createdOrder.orderId();

        orderService.deliverOrder(id);
        OrderResponseDto canceledOrder = orderService.findOrder(id);

        assertThat(canceledOrder.orderStatus()).isEqualTo(OrderStatus.DELIVERING.toString());
    }

    @DisplayName("주문 Id를 통해 주문을 배달을 완료할 수 있다.")
    @Test
    void completeOrderTest() {
        OrderCreateDto createDto = new OrderCreateDto("건희", "수원", items);
        OrderResponseDto createdOrder = orderService.create(createDto);
        long id = createdOrder.orderId();

        orderService.completeOrder(id);
        OrderResponseDto canceledOrder = orderService.findOrder(id);

        assertThat(canceledOrder.orderStatus()).isEqualTo(OrderStatus.COMPLETED.toString());
    }
}