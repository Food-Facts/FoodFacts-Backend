package com.foodfacts.foodfacts.healthrisks.interfaces.rest;

import com.foodfacts.foodfacts.healthrisks.domain.model.aggregates.HealthRisk;
import com.foodfacts.foodfacts.healthrisks.domain.model.queries.GetHealthRiskByIdQuery;
import com.foodfacts.foodfacts.healthrisks.domain.services.HealthRiskQueryService;
import com.foodfacts.foodfacts.healthrisks.interfaces.rest.resources.HealthRiskResource;
import com.foodfacts.foodfacts.healthrisks.interfaces.rest.transform.HealthRiskResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "healthRisk", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Health Risks")
@CrossOrigin(origins = "http://localhost:4200")
public class HealthRiskController {

    private final HealthRiskQueryService healthRiskQueryService;

    public HealthRiskController(HealthRiskQueryService healthRiskQueryService){
        this.healthRiskQueryService = healthRiskQueryService;
    }

    @GetMapping("{id}")
    public ResponseEntity<HealthRiskResource> getHealthRiskById(@PathVariable Long id) {
        Optional<HealthRisk> healthRisk = healthRiskQueryService.handle(new GetHealthRiskByIdQuery(id));
        return healthRisk.map(source -> ResponseEntity.ok(HealthRiskResourceFromEntityAssembler.toResourceFromEntity(source)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}