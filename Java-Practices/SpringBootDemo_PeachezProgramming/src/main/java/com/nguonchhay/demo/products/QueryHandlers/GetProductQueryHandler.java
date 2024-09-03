package com.nguonchhay.demo.products.QueryHandlers;

import com.nguonchhay.demo.Exceptions.ProductNotFoundException;
import com.nguonchhay.demo.Query;
import com.nguonchhay.demo.products.Models.Product;
import com.nguonchhay.demo.products.ProductDTO;
import com.nguonchhay.demo.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductQueryHandler implements Query<Integer, ProductDTO> {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public ResponseEntity<ProductDTO> execute(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException();
        }
        return ResponseEntity.ok(new ProductDTO(product.get()));
    }
}
