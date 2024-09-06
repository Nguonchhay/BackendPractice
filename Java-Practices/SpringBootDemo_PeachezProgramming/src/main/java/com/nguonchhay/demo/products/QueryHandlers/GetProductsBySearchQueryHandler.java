package com.nguonchhay.demo.products.QueryHandlers;

import com.nguonchhay.demo.Query;
import com.nguonchhay.demo.products.Models.Product;
import com.nguonchhay.demo.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetProductsBySearchQueryHandler implements Query<Map<String, String>, List<Product>> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<List<Product>> execute(Map<String, String> queryParams) {
        return ResponseEntity.ok(productRepository.queryProducts(queryParams.get("name"), queryParams.get("description")));
    }
}
