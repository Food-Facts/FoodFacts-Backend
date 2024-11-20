package com.foodfacts.foodfacts.products.domain.service;

import com.foodfacts.foodfacts.products.domain.model.Product;
import com.foodfacts.foodfacts.products.infrastructure.presistence.jpa.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Method to create a new product (POST)
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Method to get a product by ID (GET)
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Method to get all products (GET)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Method to delete a product by ID (DELETE)
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}