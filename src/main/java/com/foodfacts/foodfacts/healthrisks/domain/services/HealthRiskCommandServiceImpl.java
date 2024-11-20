package com.foodfacts.foodfacts.healthrisks.domain.services;

import com.foodfacts.foodfacts.healthrisks.domain.model.aggregates.HealthRisk;
import com.foodfacts.foodfacts.healthrisks.infrastructure.persistence.jpa.HealthRiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthRiskCommandServiceImpl implements HealthRiskCommandService {

    @Autowired
    private HealthRiskRepository healthRiskRepository;

    @Override
    public HealthRisk createHealthRisk(HealthRisk healthRisk) {
        return healthRiskRepository.save(healthRisk);
    }
}