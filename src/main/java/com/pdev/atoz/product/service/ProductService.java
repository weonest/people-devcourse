package com.pdev.atoz.product.service;

import com.pdev.atoz.product.dto.ProductCreateDto;
import com.pdev.atoz.product.dto.ProductResponseDto;
import com.pdev.atoz.product.dto.ProductUpdateDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto create(ProductCreateDto createDto);

    ProductResponseDto update(ProductUpdateDto updateDto);

    ProductResponseDto findProductById(long id);

    ProductResponseDto findProductByProductName(String productName);

    List<ProductResponseDto> findProducts();

    void deleteProductById(long id);
}
