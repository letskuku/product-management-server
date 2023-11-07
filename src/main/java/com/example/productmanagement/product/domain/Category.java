package com.example.productmanagement.product.domain;

import com.example.productmanagement.product.exception.CategoryNotFoundException;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Category {

    SHIRT,
    PANTS,
    SHOES;

    public static Category getCategoryByName(String name) {
        return Arrays.stream(Category.values())
                .filter(category -> category.name().equalsIgnoreCase(name))
                .findAny().orElseThrow(CategoryNotFoundException::new);
    }
}
