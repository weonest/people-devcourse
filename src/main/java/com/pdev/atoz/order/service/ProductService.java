package com.pdev.atoz.order.service;

import com.pdev.atoz.order.domain.Product;
import com.pdev.atoz.order.dto.ProductCreateDto;

public interface ProductService {

    Product create(ProductCreateDto createDto);
}
