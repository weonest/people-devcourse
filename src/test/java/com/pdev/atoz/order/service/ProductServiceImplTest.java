package com.pdev.atoz.order.service;

import com.pdev.atoz.order.domain.Category;
import com.pdev.atoz.order.dto.ProductCreateDto;
import com.pdev.atoz.order.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    @Test
    void test() {
        ProductCreateDto productCreateDto = new ProductCreateDto("밥", Category.FOOD, 1000, "맛있음");
        productService.create(productCreateDto);

    }
}