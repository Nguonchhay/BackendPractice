package com.nguonchhay.demo.products;

import com.nguonchhay.demo.products.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.price < :maxPrice")
    List<Product> findProductsWithPriceLessThan(@Param("maxPrice") double maxPrice);

    @Query("SELECT p FROM Product p WHERE name LIKE %:name% OR description LIKE %:description%")
    List<Product> queryProducts(@Param("name") String name, @Param("description") String description);
}
