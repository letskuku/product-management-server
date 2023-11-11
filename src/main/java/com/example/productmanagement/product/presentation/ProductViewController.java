package com.example.productmanagement.product.presentation;

import com.example.productmanagement.product.application.ProductService;
import com.example.productmanagement.product.dto.request.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductViewController {

    private final ProductService productService;

    @GetMapping("/new")
    public String createProductPage() {
        return "product/product-form";
    }

    @PostMapping
    public String createProduct(CreateProductRequest createProductRequest) {

        productService.createProduct(createProductRequest);

        return "redirect:/products";
    }

    @GetMapping("/{category}")
    public String getProductsByCategory(@PathVariable String category, Model model) {

        model.addAttribute("products", productService.getProductsByCategory(category));

        return "product/product-list";
    }

    @GetMapping
    public String getAllProducts(Model model) {

        model.addAttribute("products", productService.getAllProducts());

        return "product/product-list";
    }

    @PostMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId) {

        productService.deleteProduct(productId);

        return "redirect:/products";
    }
}
