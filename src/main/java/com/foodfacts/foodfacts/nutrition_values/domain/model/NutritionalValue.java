package com.foodfacts.foodfacts.nutrition_values.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class NutritionalValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String portionSize;
    private Integer calories;
    private Integer carbohydrates;
    private Integer sugar;
    private Integer sodium;
    private Integer fat;

    // Constructores, getters y setters generados por Lombok
}