package com.nguonchhay.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends BaseException {
    public ProductNotFoundException() {
        super(HttpStatus.NOT_FOUND, new SimpleResponse("Product not found"));
    }
}
