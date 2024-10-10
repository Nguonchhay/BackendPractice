package com.nguonchhay.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class ExternalCatFactException extends BaseException {

    public ExternalCatFactException(HttpStatus httpStatus, SimpleResponse simpleResponse) {
        super(httpStatus, simpleResponse);
    }
}
