package com.foodfacts.foodfacts.nutricionist.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Nutritionist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id", example = "1")
    private Long id;

    @Schema(description = "Name", example = "Jane Smith")
    private String name;

    @Schema(description = "Specialty", example = "Dietitian")
    private String specialty;

    @Schema(description = "Experience", example = "10")
    private Integer experience;

    @Schema(description = "Email", example = "jane.smith@example.com")
    private String email;

    @Schema(description = "Phone", example = "123-456-7890")
    private String phone;
}