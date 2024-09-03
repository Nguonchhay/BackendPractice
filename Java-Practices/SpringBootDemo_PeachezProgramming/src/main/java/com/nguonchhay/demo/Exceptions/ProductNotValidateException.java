package com.nguonchhay.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class ProductNotValidateException extends BaseException {
    public ProductNotValidateException(String message) {
        super(HttpStatus.BAD_REQUEST, new SimpleResponse(message));
    }
}
