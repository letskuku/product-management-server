package com.example.productmanagement.order.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum OrderErrorCode {

    ORDER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당하는 Order를 찾을 수 없습니다.");

    private final HttpStatus errorCode;
    private final String errorMessage;

    OrderErrorCode(HttpStatus errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
