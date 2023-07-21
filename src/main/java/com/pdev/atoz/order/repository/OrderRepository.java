package com.pdev.atoz.order.repository;

import com.pdev.atoz.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Modifying
    @Query ("update Order o set o.orderStatus = :orderStatus where o.id = :id")
    void updateOrderStatus(String orderStatus, long id);
}
