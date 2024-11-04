package com.foodfacts.foodfacts.nutricionist.infrastructure.persistence.jpa.repositories;


import com.foodfacts.foodfacts.nutricionist.domain.model.Nutritionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionistRepository extends JpaRepository<Nutritionist, Long> {
}