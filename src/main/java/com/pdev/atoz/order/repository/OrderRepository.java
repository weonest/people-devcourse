package com.pdev.atoz.order.repository;

import com.pdev.atoz.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Transactional
    @Modifying
    @Query ("update OrderEntity o set o.orderStatus = :orderStatus where o.id = :id")
    void updateOrderStatus(String orderStatus, long id);
}
