package com.nguonchhay.demo.products.Requests;

import lombok.Data;

@Data
public class ProductRequest {
    private int id;
    private int categoryId;
    private String name;
    private int quantity;
    private String description;
    private double price;
}
