package com.pdev.atoz.product.service;

import com.pdev.atoz.product.domain.Category;
import com.pdev.atoz.product.dto.ProductCreateDto;
import com.pdev.atoz.product.dto.ProductResponseDto;
import com.pdev.atoz.product.dto.ProductUpdateDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @DisplayName("상품 생성 요청을 통해 상품을 생성할 수 있다.")
    @Test
    void createProductTest() {
        ProductCreateDto productCreateDto = new ProductCreateDto("주먹밥", Category.FOOD, 1000, "오니기리");

        ProductResponseDto productResponseDto = productService.create(productCreateDto);

        assertThat(productResponseDto).isNotNull();
    }

    @DisplayName("상품 수정 요청을 통해 상품 정보를 수정할 수 있다.")
    @Test
    void updateProductTest() {
        ProductCreateDto productCreateDto = new ProductCreateDto("주먹밥", Category.FOOD, 1000, "오니기리");
        ProductResponseDto product = productService.create(productCreateDto);

        ProductUpdateDto updateDto = new ProductUpdateDto(product.productId(), "참치주먹밥", Category.FOOD, 1500, "맛나요");
        productService.update(updateDto);

        ProductResponseDto updatedProduct = productService.findProductById(product.productId());
        assertThat(updateDto.productName()).isEqualTo(updatedProduct.productName());
        assertThat(updateDto.price()).isEqualTo(updatedProduct.price());
        assertThat(updateDto.category().toString()).isEqualTo(updatedProduct.category());
        assertThat(updateDto.description()).isEqualTo(updatedProduct.description());
    }
}