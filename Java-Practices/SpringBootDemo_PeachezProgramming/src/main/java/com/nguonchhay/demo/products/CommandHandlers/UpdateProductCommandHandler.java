package com.nguonchhay.demo.products.CommandHandlers;

import com.nguonchhay.demo.Command;
import com.nguonchhay.demo.Exceptions.ProductNotFoundException;
import com.nguonchhay.demo.Exceptions.ProductNotValidateException;
import com.nguonchhay.demo.products.CategoryRepository;
import com.nguonchhay.demo.products.Models.Category;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @CachePut(value = "productCache", key = "#command.getId()")
    public ResponseEntity execute(UpdateProductCommand command) {
        Category category = categoryRepository.findById(command.getProductRequest().getCategoryId())
                .orElseThrow(() -> new ProductNotValidateException("Category id is required"));

        Optional<Product> queryProduct = productRepository.findById(command.getId());
        if (queryProduct.isEmpty()) {
            throw new ProductNotFoundException();
        }

        Product product = new Product();
        product.setId(command.getId());
        product.setCategory(category);
        product.setName(command.getProductRequest().getName());
        product.setQuantity(command.getProductRequest().getQuantity());
        product.setPrice(command.getProductRequest().getPrice());
        product.setDescription(command.getProductRequest().getDescription());

        productRepository.save(product);
        return ResponseEntity.ok(new ProductDTO(product));
    }
}
