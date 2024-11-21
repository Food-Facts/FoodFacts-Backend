package com.foodfacts.foodfacts.nutricionist.interfaces.rest;

import com.foodfacts.foodfacts.nutricionist.domain.model.Nutritionist;
import com.foodfacts.foodfacts.nutricionist.domain.services.NutritionistService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nutritionists")
@Tag(name = "Nutritionists", description = "Available Nutritionists Values Endpoints")
public class NutritionistsController {

    private final NutritionistService nutritionistService;

    public NutritionistsController(NutritionistService nutritionistService) {
        this.nutritionistService = nutritionistService;
    }

    @GetMapping
    public List<Nutritionist> getAllNutritionists() {
        return nutritionistService.getAllNutritionists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nutritionist> getNutritionistById(@PathVariable Long id) {
        Optional<Nutritionist> nutritionist = nutritionistService.getNutritionistById(id);
        return nutritionist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Nutritionist> createNutritionist(@RequestBody Nutritionist nutritionist) {
        Nutritionist createdNutritionist = nutritionistService.createNutritionist(nutritionist);
        return ResponseEntity.ok(createdNutritionist);
    }
}