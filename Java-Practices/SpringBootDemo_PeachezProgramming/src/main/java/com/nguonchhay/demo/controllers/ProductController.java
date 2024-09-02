package com.nguonchhay.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public ResponseEntity getProduct() {
        return ResponseEntity.status(HttpStatus.FOUND).body(Collections.emptyList());
    }
}
