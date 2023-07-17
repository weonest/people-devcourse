package com.pdev.atoz.product.controller;

import com.pdev.atoz.product.dto.ProductResponseDto;
import com.pdev.atoz.product.dto.ProductUpdateDto;
import com.pdev.atoz.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/products")
public class RestProductController {

    private ProductService productService;

    public RestProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> updateProduct(@Valid @RequestBody ProductUpdateDto updateDto) {
        ProductResponseDto responseDto = productService.update(updateDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
