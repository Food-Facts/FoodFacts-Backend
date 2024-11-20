package com.foodfacts.foodfacts.nutricionist.domain.services;

import com.foodfacts.foodfacts.nutricionist.domain.model.Nutritionist;
import com.foodfacts.foodfacts.nutricionist.infrastructure.persistence.jpa.repositories.NutritionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutritionistService {

    private final NutritionistRepository nutritionistRepository;

    public NutritionistService(NutritionistRepository nutritionistRepository) {
        this.nutritionistRepository = nutritionistRepository;
    }

    // Method to create a new nutritionist (POST)
    public Nutritionist createNutritionist(Nutritionist nutritionist) {
        return nutritionistRepository.save(nutritionist);
    }

    // Method to get a nutritionist by ID (GET)
    public Optional<Nutritionist> getNutritionistById(Long id) {
        return nutritionistRepository.findById(id);
    }

    // Method to get all nutritionists (GET)
    public List<Nutritionist> getAllNutritionists() {
        return nutritionistRepository.findAll();
    }
}