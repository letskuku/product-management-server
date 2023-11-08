package com.example.productmanagement.product.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ProductErrorCode {

    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "해당하는 Product를 찾을 수 없습니다."),
    CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "해당하는 Category를 찾을 수 없습니다."),
    ILLEGAL_STOCK_AMOUNT(HttpStatus.BAD_REQUEST, "상품 재고를 초과한 요청입니다."),
    ILLEGAL_NEGATIVE_NUMBER(HttpStatus.BAD_REQUEST, "0 이하의 수가 입력되었습니다.");

    private final HttpStatus errorCode;
    private final String errorMessage;

    ProductErrorCode(HttpStatus errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
