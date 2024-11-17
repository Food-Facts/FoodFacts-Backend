package com.foodfacts.foodfacts.products.domain.service;

import com.foodfacts.foodfacts.products.domain.model.Product;
import com.foodfacts.foodfacts.products.infrastructure.presistence.jpa.repositories.ProductRepository;
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

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            product.setCategory(productDetails.getCategory());
            product.setBrand(productDetails.getBrand());
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


    public List<Product> getProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public List<Product> getProductsOrderedByNameAsc() {
        return productRepository.findAllByOrderByNameAsc();
    }

    public List<Product> getProductsOrderedByNameDesc() {
        return productRepository.findAllByOrderByNameDesc();
    }

    public List<Product> searchProductsByNameAndOrderByNameAsc(String name) {
        return productRepository.searchByNameAndOrderByNameAsc(name);
    }
}
