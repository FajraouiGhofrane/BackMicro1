package com.esprit.microservice.nutrition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionRepository extends JpaRepository<Nutrition,Long> {
}
