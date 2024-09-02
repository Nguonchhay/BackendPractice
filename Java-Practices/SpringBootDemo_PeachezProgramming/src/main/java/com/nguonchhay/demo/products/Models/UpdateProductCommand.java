package com.nguonchhay.demo.products.Models;

public class UpdateProductCommand {
    private int id;
    private Product product;

    public UpdateProductCommand(int id, Product product) {
        this.id = id;
        this.product = product;
    }

    public Product getUpdatedProduct() {
        product.setId(id);
        return product;
    }
}
