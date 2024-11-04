package com.foodfacts.foodfacts.products.domain.model;

import com.foodfacts.foodfacts.nutrition_values.domain.model.NutritionalValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

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

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<NutritionalValue> nutritionalValues;

    // Getters and setters...

}