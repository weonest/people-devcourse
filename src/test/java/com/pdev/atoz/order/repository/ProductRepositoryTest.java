package com.pdev.atoz.order.repository;

import com.pdev.atoz.order.domain.Category;
import com.pdev.atoz.order.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

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