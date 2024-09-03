package com.nguonchhay.demo.products.CommandHandlers;

import com.nguonchhay.demo.Command;
import com.nguonchhay.demo.Exceptions.ProductNotFoundException;
import com.nguonchhay.demo.products.Models.Product;
import com.nguonchhay.demo.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductCommandHandler implements Command<Integer, ResponseEntity> {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public ResponseEntity execute(Integer id) {
        Optional<Product> queryProduct = productRepository.findById(id);
        if (queryProduct.isEmpty()) {
            throw new ProductNotFoundException();
        }

        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
