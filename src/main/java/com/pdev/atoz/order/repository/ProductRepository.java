package com.pdev.atoz.order.repository;

import com.pdev.atoz.order.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
