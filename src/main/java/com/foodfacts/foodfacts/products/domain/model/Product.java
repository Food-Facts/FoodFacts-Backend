package com.foodfacts.foodfacts.products.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String category;
    private String brand;
    private int portionSize;
    private int calories;
    private int carbohydrates;
    private int sugar;
    private int sodium;
    private int fat;
    private int proteins; // Added field
    private int fibers;   // Added field

    // Getters and Setters

}