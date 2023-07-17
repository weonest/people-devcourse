package com.pdev.atoz.product.service;

import com.pdev.atoz.product.domain.Product;
import com.pdev.atoz.product.domain.ProductMapper;
import com.pdev.atoz.product.dto.ProductCreateDto;
import com.pdev.atoz.product.dto.ProductResponseDto;
import com.pdev.atoz.product.dto.ProductUpdateDto;
import com.pdev.atoz.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Transactional(readOnly = true)
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public ProductResponseDto create(ProductCreateDto createDto) {
        Product product = ProductMapper.convertCreateToEntity(createDto, createDto.category(), LocalDateTime.now());
        productRepository.save(product);
        return ProductMapper.convertEntityToResponse(product);
    }

    @Transactional
    @Override
    public ProductResponseDto update(ProductUpdateDto updateDto) {
        Product product = productRepository.findById(updateDto.productId()).get();
        product.changeProduct(updateDto);
        return ProductMapper.convertEntityToResponse(product);
    }

    @Override
    public ProductResponseDto findProductBy(long id) {
        Product product = productRepository.findById(id).get();
        return ProductMapper.convertEntityToResponse(product);
    }

    @Override
    public ProductResponseDto findProductByProductName(String productName) {
        Product product = productRepository.findByProductName(productName).get();
        return ProductMapper.convertEntityToResponse(product);
    }

    @Transactional
    @Override
    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }
}
