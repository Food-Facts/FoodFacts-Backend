package com.foodfacts.foodfacts.healthrisks.domain.services;

import com.foodfacts.foodfacts.healthrisks.domain.model.aggregates.HealthRisk;
import com.foodfacts.foodfacts.healthrisks.domain.model.queries.GetHealthRiskByIdQuery;

import java.util.Optional;

public interface HealthRiskQueryService {
    Optional<HealthRisk> handle(GetHealthRiskByIdQuery query);
}