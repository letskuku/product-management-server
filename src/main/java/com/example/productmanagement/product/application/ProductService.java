package com.example.productmanagement.product.application;

import com.example.productmanagement.product.dto.request.CreateProductRequest;
import com.example.productmanagement.product.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {

    void createProduct(CreateProductRequest createProductRequest);

    List<ProductResponse> getProductsByCategory(String category);

    List<ProductResponse> getAllProducts();
}
