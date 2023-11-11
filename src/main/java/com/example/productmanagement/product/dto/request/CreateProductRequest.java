package com.example.productmanagement.product.dto.request;

import com.example.productmanagement.product.domain.Category;
import com.example.productmanagement.product.domain.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateProductRequest {

    private final String name;
    private final String category;
    private final String description;
    private final Long price;
    private final Long stock;

    @Builder
    public CreateProductRequest(String name, String category, String description, Long price, Long stock) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Product toEntity() {
        return Product.builder()
                .name(name)
                .category(Category.getCategoryByName(category))
                .description(description)
                .price(price)
                .stock(stock)
                .build();
    }
}
