package com.example.micro.demo.first.microproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product createProduct(Product product) {
        if (productRepository.existsById(product.getId())) {
            throw new IllegalArgumentException("Product with id " + product.getId() + " already exists.");
        }
        return productRepository.save(product);
    }

    public Product updateProduct(String id, Product product) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
}
