package com.nguonchhay.demo.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<SimpleResponse> handleProductNotFoundException(BaseException baseException) {
        return ResponseEntity.status(baseException.getHttpStatus())
                .body(baseException.getSimpleResponse());
    }
}
