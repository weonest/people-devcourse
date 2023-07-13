package com.pdev.atoz.order.service;

import com.pdev.atoz.order.domain.Product;
import com.pdev.atoz.order.dto.ProductCreateDto;
import com.pdev.atoz.order.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(ProductCreateDto createDto) {
        Product product = new Product(createDto.productName(),
                createDto.category(),
                createDto.price(),
                createDto.description(),
                LocalDateTime.now());
        return productRepository.save(product);
    }
}
