package com.foodfacts.foodfacts.healthrisks.infrastructure.persistence.jpa;



import com.foodfacts.foodfacts.healthrisks.domain.model.aggregates.HealthRisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRiskRepository extends JpaRepository<HealthRisk, Long> {
}