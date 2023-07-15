package com.pdev.atoz.product.repository;

import com.pdev.atoz.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
