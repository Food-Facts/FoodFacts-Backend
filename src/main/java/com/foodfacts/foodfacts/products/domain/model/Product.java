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
    @Schema(description = "id", example = "0")
    private Long id;

    @Schema(description = "Name", example = "String")
    private String name;

    @Schema(description = "Description", example = "String")
    private String description;

    @Schema(description = "Category", example = "String")
    private String category;

    @Schema(description = "Brand", example = "String")
    private String brand;

    @Schema(description = "Size_Portion ", example = "0")
    private int portionSize;

    @Schema(description = "Calories n", example = "0")
    private int calories;

    @Schema(description = "Carbohydrates ", example = "0")
    private int carbohydrates;

    @Schema(description = "Sugar", example = "0")
    private int sugar;

    @Schema(description = "Sodium", example = "0")
    private int sodium;

    @Schema(description = "Fat", example = "0")
    private int fat;

    @Schema(description = "Protein", example = "0")
    private int proteins;

    @Schema(description = "Fiber", example = "0")
    private int fibers;
}