package com.foodfacts.foodfacts.nutrition_values.interfaces.rest;

import com.foodfacts.foodfacts.nutrition_values.domain.model.NutritionalValue;
import com.foodfacts.foodfacts.nutrition_values.domain.services.NutritionalValueService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nutritional-values")
@Tag(name = "Nutrition Values", description = "Available Nutrition Values Endpoints")
public class NutritionalValueController {

    @Autowired
    private NutritionalValueService nutritionalValueService;

    @GetMapping
    public List<NutritionalValue> getAllNutritionalValues() {
        return nutritionalValueService.getAllNutritionalValues();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NutritionalValue> getNutritionalValueById(@PathVariable Long id) {
        Optional<NutritionalValue> nutritionalValue = nutritionalValueService.getNutritionalValueById(id);
        return nutritionalValue.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}