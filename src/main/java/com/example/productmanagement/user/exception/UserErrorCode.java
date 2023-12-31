package com.example.productmanagement.user.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum UserErrorCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당하는 User를 찾을 수 없습니다.");

    private final HttpStatus errorCode;
    private final String errorMessage;

    UserErrorCode(HttpStatus errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
