package com.nguonchhay.demo.products.QueryHandlers;

import com.nguonchhay.demo.Query;
import com.nguonchhay.demo.products.Models.Product;
import com.nguonchhay.demo.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsByPriceQueryHandler implements Query<Double, List<Product>> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<List<Product>> execute(Double maxPrice) {
        return ResponseEntity.ok(productRepository.findProductsWithPriceLessThan(maxPrice));
    }
}
