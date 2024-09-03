package com.nguonchhay.demo.products.CommandHandlers;

import com.nguonchhay.demo.Command;
import com.nguonchhay.demo.Exceptions.ProductNotValidateException;
import com.nguonchhay.demo.products.Models.Product;
import com.nguonchhay.demo.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductCommandHandler implements Command<Product, ResponseEntity> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity execute(Product product) {
        validateProduct(product);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    private void validateProduct(Product product) {
        if (product.getCategoryId() <= 0) {
            throw new ProductNotValidateException("Category id is required");
        }

        if (product.getName().isEmpty()) {
            throw new ProductNotValidateException("Product name is required");
        }

        if (product.getPrice() <= 0.0) {
            throw new ProductNotValidateException("Price is required");
        }

        if (product.getQuantity() <= 0) {
            throw new ProductNotValidateException("Quantity is required");
        }
    }
}
