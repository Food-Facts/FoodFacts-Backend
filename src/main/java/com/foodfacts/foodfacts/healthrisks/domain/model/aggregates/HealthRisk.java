package com.foodfacts.foodfacts.healthrisks.domain.model.aggregates;

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
public class HealthRisk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id", example = "1")
    private Long id;

    @Schema(description = "Title", example = "High Blood Pressure")
    private String title;

    @Schema(description = "Description", example = "A condition in which the force of the blood against the artery walls is too high.")
    private String description;
}