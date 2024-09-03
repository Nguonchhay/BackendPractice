package com.nguonchhay.demo.products;

import com.nguonchhay.demo.products.Models.Product;
import lombok.Data;

@Data
public class ProductDTO {
    private int id;
    private int categoryId;
    private String name;
    private String description;
    private double price;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.categoryId = product.getCategoryId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }
}
