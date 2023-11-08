package com.example.productmanagement.product.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ProductException extends RuntimeException {

    private final HttpStatus errorCode;

    public ProductException(ProductErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode.getErrorCode();
    }

    public ProductException(ProductErrorCode errorCode, Long id) {
        super(errorCode.getErrorMessage() + " : " + id);
        this.errorCode = errorCode.getErrorCode();
    }
}
