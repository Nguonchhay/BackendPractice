package com.nguonchhay.demo.products.CommandHandlers;

import com.nguonchhay.demo.Command;
import com.nguonchhay.demo.products.Models.Product;
import com.nguonchhay.demo.products.Models.UpdateProductCommand;
import com.nguonchhay.demo.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductCommandHandler implements Command<UpdateProductCommand, ResponseEntity> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity execute(UpdateProductCommand command) {
        productRepository.save(command.getUpdatedProduct());
        return ResponseEntity.ok().build();
    }
}
