package com.example.productmanagement.product.application;

import com.example.productmanagement.product.dto.request.CreateProductRequest;
import com.example.productmanagement.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void createProduct(CreateProductRequest createProductRequest) {
        productRepository.save(createProductRequest.toEntity());
    }
}
