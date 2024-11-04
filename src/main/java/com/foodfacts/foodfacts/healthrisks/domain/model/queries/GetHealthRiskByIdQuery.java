package com.foodfacts.foodfacts.healthrisks.domain.model.queries;

public record GetHealthRiskByIdQuery(Long id) {
    public GetHealthRiskByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
    }
}