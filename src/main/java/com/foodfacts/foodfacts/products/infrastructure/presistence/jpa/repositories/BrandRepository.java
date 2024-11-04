package com.foodfacts.foodfacts.products.infrastructure.presistence.jpa.repositories;

import com.foodfacts.foodfacts.products.domain.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
