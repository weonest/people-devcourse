package com.pdev.atoz.product.controller;

import com.pdev.atoz.product.dto.ProductCreateDto;
import com.pdev.atoz.product.dto.ProductResponseDto;
import com.pdev.atoz.product.service.ProductService;
import com.pdev.atoz.user.domain.User;
import com.pdev.atoz.user.domain.UserRole;
import com.pdev.atoz.user.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
@RequestMapping("/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;
    private UserServiceImpl userServiceImpl;

    public ProductController(ProductService productService, UserServiceImpl userServiceImpl) {
        this.productService = productService;
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public String productsPage(@SessionAttribute(name = "userId") long userId, Model model) {

        User loginUser = userServiceImpl.getLoginUserById(userId);

        if (loginUser == null) {
            return "redirect:/session/login";
        }

        if (!loginUser.getRole().equals(UserRole.ADMIN)) {
            return "redirect:/session";
        }

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
    public String productsPage(@RequestBody @Valid ProductCreateDto createDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            logger.warn("에러 사항 -> {}", bindingResult.getFieldErrors());
            return "product-new";
        }

        productService.create(createDto);
        return "redirect:/products";
    }

}
