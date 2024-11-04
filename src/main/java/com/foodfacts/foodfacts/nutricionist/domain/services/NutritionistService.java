package com.foodfacts.foodfacts.nutricionist.domain.services;

import com.foodfacts.foodfacts.nutricionist.domain.model.Nutritionist;
import com.foodfacts.foodfacts.nutricionist.infrastructure.persistence.jpa.repositories.NutritionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutritionistService {

    @Autowired
    private NutritionistRepository nutritionistRepository;

    public List<Nutritionist> getAllNutritionists() {
        return nutritionistRepository.findAll();
    }

    public Optional<Nutritionist> getNutritionistById(Long id) {
        return nutritionistRepository.findById(id);
    }

    public Nutritionist createNutritionist(Nutritionist nutritionist) {
        return nutritionistRepository.save(nutritionist);
    }

    public Nutritionist updateNutritionist(Long id, Nutritionist nutritionistDetails) {
        Optional<Nutritionist> nutritionist = nutritionistRepository.findById(id);
        if (nutritionist.isPresent()) {
            Nutritionist updatedNutritionist = nutritionist.get();
            updatedNutritionist.setName(nutritionistDetails.getName());
            updatedNutritionist.setSpecialty(nutritionistDetails.getSpecialty());
            updatedNutritionist.setExperience(nutritionistDetails.getExperience());
            updatedNutritionist.setEmail(nutritionistDetails.getEmail());
            updatedNutritionist.setPhone(nutritionistDetails.getPhone());
            return nutritionistRepository.save(updatedNutritionist);
        } else {
            return null;
        }
    }

    public void deleteNutritionist(Long id) {
        nutritionistRepository.deleteById(id);
    }
}