package com.example.productmanagement.product.dto.response;

import com.example.productmanagement.product.domain.Category;
import com.example.productmanagement.product.domain.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductResponse {

    private final Long id;
    private final String name;
    private final Category category;
    private final String description;
    private final Long price;
    private final Long stock;

    @Builder
    public ProductResponse(Long id, String name, Category category, String description, Long price, Long stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public static ProductResponse fromEntity(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }
}
