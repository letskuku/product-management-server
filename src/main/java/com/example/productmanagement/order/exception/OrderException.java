package com.example.productmanagement.order.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OrderException extends RuntimeException {

    private final HttpStatus errorCode;

    public OrderException(OrderErrorCode errorCode, Long id) {
        super(errorCode.getErrorMessage() + " : " + id);
        this.errorCode = errorCode.getErrorCode();
    }
}
