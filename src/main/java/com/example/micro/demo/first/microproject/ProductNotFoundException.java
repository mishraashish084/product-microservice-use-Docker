package com.example.micro.demo.first.microproject;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String id) {
        super("Product with id " + id + " not found.");
    }
}
