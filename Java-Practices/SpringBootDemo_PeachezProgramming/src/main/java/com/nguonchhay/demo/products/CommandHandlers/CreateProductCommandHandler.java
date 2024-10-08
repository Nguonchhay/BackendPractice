package com.nguonchhay.demo.products.CommandHandlers;

import com.nguonchhay.demo.Command;
import com.nguonchhay.demo.Exceptions.ProductNotValidateException;
import com.nguonchhay.demo.products.CategoryRepository;
import com.nguonchhay.demo.products.Models.Category;
import com.nguonchhay.demo.products.Models.Product;
import com.nguonchhay.demo.products.ProductRepository;
import com.nguonchhay.demo.products.Requests.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductCommandHandler implements Command<ProductRequest, ResponseEntity> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ResponseEntity execute(ProductRequest productRequest) {
        Product product = validateProduct(productRequest);
        productRepository.save(product);
        return ResponseEntity.ok(product);
    }

    private Product validateProduct(ProductRequest productRequest) {
        Category category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() -> new ProductNotValidateException("Category id is required"));

        if (productRequest.getName().isEmpty()) {
            throw new ProductNotValidateException("Product name is required");
        }

        if (productRequest.getPrice() <= 0.0) {
            throw new ProductNotValidateException("Price is required");
        }

        if (productRequest.getQuantity() <= 0) {
            throw new ProductNotValidateException("Quantity is required");
        }

        Product product = new Product();
        product.setCategory(category);
        product.setName(productRequest.getName());
        product.setQuantity(productRequest.getQuantity());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());

        return product;
    }
}
