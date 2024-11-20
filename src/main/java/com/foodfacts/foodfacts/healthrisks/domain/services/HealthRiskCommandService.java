package com.foodfacts.foodfacts.healthrisks.domain.services;

import com.foodfacts.foodfacts.healthrisks.domain.model.aggregates.HealthRisk;

public interface HealthRiskCommandService {
    HealthRisk createHealthRisk(HealthRisk healthRisk);
}