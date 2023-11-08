package com.example.productmanagement.global.exception;

import com.example.productmanagement.product.exception.ProductException;
import com.example.productmanagement.user.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<String> catchProductException(ProductException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> catchUserException(UserException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
    }
}
