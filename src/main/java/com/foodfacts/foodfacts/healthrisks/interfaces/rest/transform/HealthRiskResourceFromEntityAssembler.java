package com.foodfacts.foodfacts.healthrisks.interfaces.rest.transform;

import com.foodfacts.foodfacts.healthrisks.domain.model.aggregates.HealthRisk;
import com.foodfacts.foodfacts.healthrisks.interfaces.rest.resources.HealthRiskResource;

public class HealthRiskResourceFromEntityAssembler {
    public static HealthRiskResource toResourceFromEntity(HealthRisk entity){
        return new HealthRiskResource(entity.getId(), entity.getTitle(), entity.getDescription());
    }
}