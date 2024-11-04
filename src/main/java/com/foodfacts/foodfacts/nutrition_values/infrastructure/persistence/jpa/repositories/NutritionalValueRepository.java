package com.foodfacts.foodfacts.nutrition_values.infrastructure.persistence.jpa.repositories;

import com.foodfacts.foodfacts.nutrition_values.domain.model.NutritionalValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionalValueRepository extends JpaRepository<NutritionalValue, Long> {
}
