package com.pdev.atoz.product.controller;

import com.pdev.atoz.product.dto.ProductCreateDto;
import com.pdev.atoz.product.dto.ProductResponseDto;
import com.pdev.atoz.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String productsPage(Model model) {
        List<ProductResponseDto> products = productService.findProducts();
        model.addAttribute("products", products);
        return "product-page";
    }

    @GetMapping("/new")
    public String newProductPage() {
        return "product-new";
    }

    @GetMapping("/{id}")
    public String productDetailPage(@PathVariable long id, Model model) {
        ProductResponseDto product = productService.findProductById(id);
        model.addAttribute("model", product);
        return "product-detail";
    }

    @PostMapping("/new")
    public String productsPage(@Valid @RequestBody ProductCreateDto createDto) {
        productService.create(createDto);
        return "redirect:/products";
    }

}
