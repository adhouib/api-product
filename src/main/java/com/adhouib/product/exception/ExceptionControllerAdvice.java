package com.adhouib.product.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(TechnicalException.class)
    ResponseEntity<?> technicalException(TechnicalException e) {
        return ResponseEntity.notFound().build();
    }
}
