package com.pdev.atoz.product.service;

import com.pdev.atoz.product.domain.Product;
import com.pdev.atoz.product.dto.ProductCreateDto;

public interface ProductService {

    Product create(ProductCreateDto createDto);
}
