package com.example.productmanagement.product.application;

import com.example.productmanagement.product.domain.Category;
import com.example.productmanagement.product.dto.request.CreateProductRequest;
import com.example.productmanagement.product.dto.response.ProductResponse;
import com.example.productmanagement.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<ProductResponse> getProductsByCategory(String categoryString) {

        Category category = Category.getCategoryByName(categoryString);

        List<ProductResponse> productResponses = productRepository.findAllByCategoryAndIsActivated(category, true)
                .stream()
                .map(ProductResponse::fromEntity)
                .toList();

        return productResponses;
    }

    @Override
    public List<ProductResponse> getAllProducts() {

        List<ProductResponse> productResponses = productRepository.findAllByIsActivated(true)
                .stream()
                .map(ProductResponse::fromEntity)
                .toList();

        return productResponses;
    }
}
