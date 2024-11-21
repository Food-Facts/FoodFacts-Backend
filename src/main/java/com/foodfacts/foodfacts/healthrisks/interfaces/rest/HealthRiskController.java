package com.foodfacts.foodfacts.healthrisks.interfaces.rest;

import com.foodfacts.foodfacts.healthrisks.domain.model.aggregates.HealthRisk;
import com.foodfacts.foodfacts.healthrisks.domain.model.queries.GetHealthRiskByIdQuery;
import com.foodfacts.foodfacts.healthrisks.domain.services.HealthRiskQueryService;
import com.foodfacts.foodfacts.healthrisks.domain.services.HealthRiskCommandService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/healthRisks", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Health Risks", description = "Health Risks Management Endpoints")
@CrossOrigin(origins = "*")
public class HealthRiskController {

    private final HealthRiskQueryService healthRiskQueryService;
    private final HealthRiskCommandService healthRiskCommandService;

    @Autowired
    public HealthRiskController(HealthRiskQueryService healthRiskQueryService, HealthRiskCommandService healthRiskCommandService){
        this.healthRiskQueryService = healthRiskQueryService;
        this.healthRiskCommandService = healthRiskCommandService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthRisk> getHealthRiskById(@PathVariable Long id) {
        Optional<HealthRisk> healthRisk = healthRiskQueryService.handle(new GetHealthRiskByIdQuery(id));
        return healthRisk.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HealthRisk> createHealthRisk(@RequestBody HealthRisk healthRisk) {
        HealthRisk createdHealthRisk = healthRiskCommandService.createHealthRisk(healthRisk);
        return ResponseEntity.ok(createdHealthRisk);
    }
}