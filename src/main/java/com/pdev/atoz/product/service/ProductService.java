package com.pdev.atoz.product.service;

import com.pdev.atoz.product.dto.ProductCreateDto;
import com.pdev.atoz.product.dto.ProductResponseDto;
import com.pdev.atoz.product.dto.ProductUpdateDto;

public interface ProductService {

    ProductResponseDto create(ProductCreateDto createDto);

    ProductResponseDto update(ProductUpdateDto updateDto);

    ProductResponseDto findProductBy(long id);

    ProductResponseDto findProductByProductName(String productName);

    void deleteProductById(long id);
}
