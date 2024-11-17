package com.foodfacts.foodfacts.products.infrastructure.presistence.jpa.repositories;

import com.foodfacts.foodfacts.products.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findByNameContainingIgnoreCase(String name);


    List<Product> findByCategoryId(Long categoryId);


    List<Product> findAllByOrderByNameAsc();


    List<Product> findAllByOrderByNameDesc();


    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) ORDER BY p.name ASC")
    List<Product> searchByNameAndOrderByNameAsc(@Param("name") String name);
}