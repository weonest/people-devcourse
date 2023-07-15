package com.pdev.atoz.order.repository;

import com.pdev.atoz.order.domain.Category;
import com.pdev.atoz.product.domain.Product;
import com.pdev.atoz.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void test() {

        Product product = new Product("밥", Category.FOOD, 100, "good", LocalDateTime.now());

        productRepository.save(product);
    }

}