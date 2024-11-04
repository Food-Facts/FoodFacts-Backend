package com.foodfacts.foodfacts.nutrition_values.domain.model;

import com.foodfacts.foodfacts.products.domain.model.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class NutritionalValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private double portionSize;
    @Getter
    @Setter
    private int calories;
    @Setter
    @Getter
    private double carbohydrates;
    @Setter
    @Getter
    private double sugar;
    @Getter
    @Setter
    private double sodium;
    @Getter
    @Setter
    private double fat;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Getters and setters...

}