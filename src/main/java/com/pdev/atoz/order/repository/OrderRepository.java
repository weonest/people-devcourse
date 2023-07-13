package com.pdev.atoz.order.repository;

import com.pdev.atoz.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
