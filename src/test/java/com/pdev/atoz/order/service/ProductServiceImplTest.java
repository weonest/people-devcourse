package com.pdev.atoz.order.service;

import com.pdev.atoz.order.domain.Category;
import com.pdev.atoz.product.dto.ProductCreateDto;
import com.pdev.atoz.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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