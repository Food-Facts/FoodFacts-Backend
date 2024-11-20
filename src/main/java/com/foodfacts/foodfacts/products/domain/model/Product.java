package com.foodfacts.foodfacts.products.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the product", example = "0")
    private Long id;

    @Schema(description = "Name of the product", example = "String")
    private String name;

    @Schema(description = "Description of the product", example = "String")
    private String description;

    @Schema(description = "Category of the product", example = "String")
    private String category;

    @Schema(description = "Brand of the product", example = "String")
    private String brand;

    @Schema(description = "Size of one portion in grams", example = "0")
    private int portionSize;

    @Schema(description = "Calories per portion", example = "0")
    private int calories;

    @Schema(description = "Carbohydrates per portion in grams", example = "0")
    private int carbohydrates;

    @Schema(description = "Sugar content per portion in grams", example = "0")
    private int sugar;

    @Schema(description = "Sodium content per portion in milligrams", example = "0")
    private int sodium;

    @Schema(description = "Fat content per portion in grams", example = "0")
    private int fat;

    @Schema(description = "Protein content per portion in grams", example = "0")
    private int proteins;

    @Schema(description = "Fiber content per portion in grams", example = "0")
    private int fibers;

    // Getters and Setters (handled by Lombok)
}
