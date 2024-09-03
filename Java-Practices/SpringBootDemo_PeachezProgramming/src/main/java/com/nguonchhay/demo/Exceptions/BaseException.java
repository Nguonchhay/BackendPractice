package com.nguonchhay.demo.Exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BaseException extends RuntimeException {
    private HttpStatus httpStatus;
    private SimpleResponse simpleResponse;

    public BaseException(HttpStatus httpStatus, SimpleResponse simpleResponse) {
        this.httpStatus = httpStatus;
        this.simpleResponse = simpleResponse;
    }
}
