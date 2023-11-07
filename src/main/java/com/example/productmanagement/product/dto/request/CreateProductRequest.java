package com.example.productmanagement.product.dto.request;

import com.example.productmanagement.product.domain.Category;
import com.example.productmanagement.product.domain.Product;
import lombok.Getter;

@Getter
public class CreateProductRequest {

    private String name;
    private String category;
    private String description;
    private Long price;
    private Long stock;

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
