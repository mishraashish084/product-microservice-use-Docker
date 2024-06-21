package com.example.micro.demo.first.microproject;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByName(String name); // Custom query method to find products by name

    Optional<Product> findById(String id); // Inherited method to find a product by its ID
}
