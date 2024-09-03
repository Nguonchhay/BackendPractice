package com.nguonchhay.demo.products.QueryHandlers;

import com.nguonchhay.demo.Query;
import com.nguonchhay.demo.products.Models.Product;
import com.nguonchhay.demo.products.ProductDTO;
import com.nguonchhay.demo.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductsQueryHandler implements Query<Void, List<ProductDTO>> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<List<ProductDTO>> execute(Void input) {
        List<ProductDTO> products = productRepository
                .findAll()
                .stream()
                .map(ProductDTO::new)
                .toList();

        return ResponseEntity.ok(products);
    }
}
