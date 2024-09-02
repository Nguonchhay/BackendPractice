package com.nguonchhay.demo.products.QueryHandlers;

import com.nguonchhay.demo.Query;
import com.nguonchhay.demo.products.Models.Product;
import com.nguonchhay.demo.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductQueryHandler implements Query<Integer, Product> {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public ResponseEntity<Product> execute(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new RuntimeException("Product not found!");
        }
        return ResponseEntity.ok(product.get());
    }
}
