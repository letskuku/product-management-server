package com.example.productmanagement.product.dto.response;

import com.example.productmanagement.product.domain.Category;
import com.example.productmanagement.product.domain.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductResponse {

    private final Long productId;
    private final String name;
    private final Category category;
    private final String description;
    private final Long price;
    private final Long stock;

    @Builder
    public ProductResponse(Long productId, String name, Category category, String description, Long price, Long stock) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public static ProductResponse fromEntity(Product product) {
        return ProductResponse.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .category(product.getCategory())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }
}
