package com.example.productmanagement.product.exception;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException() {
        super("해당하는 Category를 찾을 수 없습니다.");
    }
}
