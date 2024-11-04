package com.foodfacts.foodfacts.healthrisks.application.internal.queryservices;

import com.foodfacts.foodfacts.healthrisks.domain.model.aggregates.HealthRisk;
import com.foodfacts.foodfacts.healthrisks.domain.model.queries.GetHealthRiskByIdQuery;
import com.foodfacts.foodfacts.healthrisks.domain.services.HealthRiskQueryService;
import com.foodfacts.foodfacts.healthrisks.infrastructure.persistence.jpa.HealthRiskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HealthRiskQueryServiceImpl implements HealthRiskQueryService {
    public final HealthRiskRepository healthRiskRepository;

    public HealthRiskQueryServiceImpl(HealthRiskRepository healthRiskRepository) {
        this.healthRiskRepository = healthRiskRepository;
    }

    @Override
    public Optional<HealthRisk> handle(GetHealthRiskByIdQuery query){
        return healthRiskRepository.findById(query.id());
    }
}