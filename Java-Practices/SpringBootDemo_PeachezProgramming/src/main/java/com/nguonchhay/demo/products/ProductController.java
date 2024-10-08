package com.nguonchhay.demo.products;

import com.nguonchhay.demo.products.CommandHandlers.CreateProductCommandHandler;
import com.nguonchhay.demo.products.CommandHandlers.DeleteProductCommandHandler;
import com.nguonchhay.demo.products.CommandHandlers.UpdateProductCommandHandler;
import com.nguonchhay.demo.products.Models.Product;
import com.nguonchhay.demo.products.Models.UpdateProductCommand;
import com.nguonchhay.demo.products.QueryHandlers.GetAllProductsQueryHandler;
import com.nguonchhay.demo.products.QueryHandlers.GetProductQueryHandler;
import com.nguonchhay.demo.products.QueryHandlers.GetProductsByPriceQueryHandler;
import com.nguonchhay.demo.products.QueryHandlers.GetProductsBySearchQueryHandler;
import com.nguonchhay.demo.products.Requests.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private GetProductsBySearchQueryHandler getProductsBySearchQueryHandler;

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

    @GetMapping("/search")
    public ResponseEntity<List<Product>> getProductsByQuery(@RequestParam("name") String name, @RequestParam(value = "description", required = false) String description) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name", name);
        queryParams.put("description", description);
        return getProductsBySearchQueryHandler.execute(queryParams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer id) {
        return getProductQueryHandler.execute(id);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductRequest productRequest) {
       return createProductCommandHandler.execute(productRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody ProductRequest productRequest) {
        UpdateProductCommand command = new UpdateProductCommand(id, productRequest);
        return updateProductCommandHandler.execute(command);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        return deleteProductCommandHandler.execute(id);
    }
}
