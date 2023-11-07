package com.example.productmanagement.product.application;

import com.example.productmanagement.product.dto.request.CreateProductRequest;

public interface ProductService {

    void createProduct(CreateProductRequest createProductRequest);
}
