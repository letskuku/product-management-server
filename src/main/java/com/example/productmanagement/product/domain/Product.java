package com.example.productmanagement.product.domain;

import com.example.productmanagement.global.common.BaseEntity;
import com.example.productmanagement.product.exception.ProductErrorCode;
import com.example.productmanagement.product.exception.ProductException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private Category category;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "stock", nullable = false)
    private Long stock;

    @Builder
    public Product(String name, Category category, String description, Long price, Long stock) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public void reduceStock(Long amount) {

        if (amount <= 0) {
            throw new ProductException(ProductErrorCode.ILLEGAL_NEGATIVE_NUMBER);
        } else if (this.stock < amount) {
            throw new ProductException(ProductErrorCode.ILLEGAL_STOCK_AMOUNT);
        }

        this.stock -= amount;
    }
}
