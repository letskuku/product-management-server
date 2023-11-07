package com.example.productmanagement.product.presentation;

import com.example.productmanagement.product.application.ProductService;
import com.example.productmanagement.product.dto.request.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody CreateProductRequest createProductRequest) {

        productService.createProduct(createProductRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
