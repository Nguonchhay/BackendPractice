package com.nguonchhay.demo.products.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<Product> products;
}
