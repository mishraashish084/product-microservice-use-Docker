package com.example.micro.demo.first.microproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("JPAdemo with H2 database is up and running");

    }

    @Bean
    public CommandLineRunner demo(ProductRepository repository) {
        return args -> {
            repository.save(new Product("Laptop", 999.99));
            repository.save(new Product("Smartphone", 599.99));
            repository.save(new Product("Headphones", 99.99));

            // Fetch and log data
            repository.findAll().forEach(product -> {
                System.out.println(product.toString());
            });
        };
    }
}
