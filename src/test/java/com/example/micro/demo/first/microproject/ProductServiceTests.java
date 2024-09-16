package com.example.micro.demo.first.microproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductServiceTests {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        // Mock data
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product("101", "Product 101", 101.0, "Description of Product 101"));
        mockProducts.add(new Product("102", "Product 102", 102.0, "Description of Product 102"));

        // Mock repository method
        when(productRepository.findAll()).thenReturn(mockProducts);

        // Call service method
        List<Product> products = productService.getAllProducts();

        // Verify the result
        assertNotNull(products);
        assertEquals(2, products.size());
        assertEquals("Product 101", products.get(0).getName());
        assertEquals("Product 102", products.get(1).getName());
    }

    @Test
    public void testGetProductById() {
        // Mock data
        Product mockProduct = new Product("101", "Product 101", 101.0, "Description of Product 101");

        // Mock repository method
        when(productRepository.findById("101")).thenReturn(Optional.of(mockProduct));

        // Call service method
        Product product = productService.getProductById("101");

        // Verify the result
        assertNotNull(product);
        assertEquals("Product 101", product.getName());
    }

    @Test
    public void testGetProductById_NotFound() {
        // Mock repository method to return empty Optional (simulating not found)
        when(productRepository.findById("999")).thenReturn(Optional.empty());

        // Call service method
        Exception exception = assertThrows(ProductNotFoundException.class, () -> {
            productService.getProductById("999");
        });

        // Verify exception message
        assertEquals("Product with id 999 not found.", exception.getMessage());
    }

    // Add more tests for create, update, and delete methods similarly
}
