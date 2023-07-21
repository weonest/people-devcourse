package com.pdev.atoz.order.repository;

import com.pdev.atoz.order.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

    void deleteByOrderId(Long orderId);
}
