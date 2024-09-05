package com.nguonchhay.demo.products;

import com.nguonchhay.demo.products.CommandHandlers.CreateProductCommandHandler;
import com.nguonchhay.demo.products.CommandHandlers.DeleteProductCommandHandler;
import com.nguonchhay.demo.products.CommandHandlers.UpdateProductCommandHandler;
import com.nguonchhay.demo.products.Models.Product;
import com.nguonchhay.demo.products.Models.UpdateProductCommand;
import com.nguonchhay.demo.products.QueryHandlers.GetAllProductsQueryHandler;
import com.nguonchhay.demo.products.QueryHandlers.GetProductQueryHandler;
import com.nguonchhay.demo.products.QueryHandlers.GetProductsByPriceQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private GetAllProductsQueryHandler getAllProductsQueryHandler;

    @Autowired
    private GetProductsByPriceQueryHandler getProductsByPriceQueryHandler;

    @Autowired
    private GetProductQueryHandler getProductQueryHandler;

    @Autowired
    private CreateProductCommandHandler createProductCommandHandler;

    @Autowired
    private UpdateProductCommandHandler updateProductCommandHandler;

    @Autowired
    private DeleteProductCommandHandler deleteProductCommandHandler;


    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return getAllProductsQueryHandler.execute(null);
    }

    @GetMapping("/search-price/{maxPrice}")
    public ResponseEntity<List<Product>> getProductByPrice(@PathVariable Double maxPrice) {
        return getProductsByPriceQueryHandler.execute(maxPrice);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer id) {
        return getProductQueryHandler.execute(id);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product) {
       return createProductCommandHandler.execute(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        UpdateProductCommand command = new UpdateProductCommand(id, product);
        return updateProductCommandHandler.execute(command);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        return deleteProductCommandHandler.execute(id);
    }
}
