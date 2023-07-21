package com.pdev.atoz.order.repository;

import com.pdev.atoz.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    void deleteByOrderId(Long orderId);
}
