package com.foodfacts.foodfacts.nutrition_values.domain.services;

import com.foodfacts.foodfacts.nutrition_values.domain.model.NutritionalValue;
import com.foodfacts.foodfacts.nutrition_values.infrastructure.persistence.jpa.repositories.NutritionalValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutritionalValueService {

    @Autowired
    private NutritionalValueRepository nutritionalValueRepository;

    public List<NutritionalValue> getAllNutritionalValues() {
        return nutritionalValueRepository.findAll();
    }

    public Optional<NutritionalValue> getNutritionalValueById(Long id) {
        return nutritionalValueRepository.findById(id);
    }

    public NutritionalValue createNutritionalValue(NutritionalValue nutritionalValue) {
        return nutritionalValueRepository.save(nutritionalValue);
    }

    public NutritionalValue updateNutritionalValue(Long id, NutritionalValue nutritionalValueDetails) {
        Optional<NutritionalValue> nutritionalValue = nutritionalValueRepository.findById(id);
        if (nutritionalValue.isPresent()) {
            NutritionalValue updatedNutritionalValue = nutritionalValue.get();
            updatedNutritionalValue.setPortionSize(nutritionalValueDetails.getPortionSize());
            updatedNutritionalValue.setCalories(nutritionalValueDetails.getCalories());
            updatedNutritionalValue.setCarbohydrates(nutritionalValueDetails.getCarbohydrates());
            updatedNutritionalValue.setSugar(nutritionalValueDetails.getSugar());
            updatedNutritionalValue.setSodium(nutritionalValueDetails.getSodium());
            updatedNutritionalValue.setFat(nutritionalValueDetails.getFat());
            return nutritionalValueRepository.save(updatedNutritionalValue);
        } else {
            return null;
        }
    }

    public void deleteNutritionalValue(Long id) {
        nutritionalValueRepository.deleteById(id);
    }
}
