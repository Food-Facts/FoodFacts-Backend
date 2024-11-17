package com.foodfacts.foodfacts.products.interfaces.rest;

import com.foodfacts.foodfacts.products.domain.model.Product;
import com.foodfacts.foodfacts.products.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(id, productDetails);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Product> searchProductsByName(@RequestParam String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping("/category")
    public List<Product> getProductsByCategory(@RequestParam Long categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    @GetMapping("/order/asc")
    public List<Product> getProductsOrderedByNameAsc() {
        return productService.getProductsOrderedByNameAsc();
    }

    @GetMapping("/order/desc")
    public List<Product> getProductsOrderedByNameDesc() {
        return productService.getProductsOrderedByNameDesc();
    }

    @GetMapping("/search/order/asc")
    public List<Product> searchProductsByNameAndOrderByNameAsc(@RequestParam String name) {
        return productService.searchProductsByNameAndOrderByNameAsc(name);
    }
}
