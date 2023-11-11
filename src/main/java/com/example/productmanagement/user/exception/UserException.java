package com.example.productmanagement.user.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserException extends RuntimeException {

    private final HttpStatus errorCode;

    public UserException(UserErrorCode errorCode, String email) {
        super(errorCode.getErrorMessage() + " : " + email);
        this.errorCode = errorCode.getErrorCode();
    }
}
