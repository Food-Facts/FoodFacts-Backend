package com.foodfacts.foodfacts.products.infrastructure.presistence.jpa.repositories;

import com.foodfacts.foodfacts.products.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}