package com.nguonchhay.demo.products.CommandHandlers;

import com.nguonchhay.demo.Command;
import com.nguonchhay.demo.Exceptions.ProductNotFoundException;
import com.nguonchhay.demo.products.Models.Product;
import com.nguonchhay.demo.products.Models.UpdateProductCommand;
import com.nguonchhay.demo.products.ProductDTO;
import com.nguonchhay.demo.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductCommandHandler implements Command<UpdateProductCommand, ResponseEntity> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @CachePut(value = "productCache", key = "#command.getId()")
    public ResponseEntity execute(UpdateProductCommand command) {
        Optional<Product> queryProduct = productRepository.findById(command.getId());
        if (queryProduct.isEmpty()) {
            throw new ProductNotFoundException();
        }

        productRepository.save(command.getUpdatedProduct());
        return ResponseEntity.ok(new ProductDTO(command.getUpdatedProduct()));
    }
}
