package com.nguonchhay.demo.products.Models;

import com.nguonchhay.demo.products.Requests.ProductRequest;
import lombok.Getter;

public class UpdateProductCommand {
    @Getter
    private int id;

    @Getter
    private ProductRequest productRequest;

    public UpdateProductCommand(int id, ProductRequest productRequest) {
        this.id = id;
        this.productRequest = productRequest;
    }
}
