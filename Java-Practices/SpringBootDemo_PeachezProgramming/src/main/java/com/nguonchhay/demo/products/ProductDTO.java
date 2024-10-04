package com.nguonchhay.demo.products;

import com.nguonchhay.demo.products.Models.Category;
import com.nguonchhay.demo.products.Models.Product;
import lombok.Data;

@Data
public class ProductDTO {
    private int id;
    private Category category;
    private String name;
    private String description;
    private double price;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.category = product.getCategory() != null ? product.getCategory() : null;
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }
}
