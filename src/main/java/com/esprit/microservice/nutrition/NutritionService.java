package com.esprit.microservice.nutrition;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NutritionService implements INutritionService {
    @Autowired
    private NutritionRepository nutritionRepository;

    public Nutrition addNutrition(Nutrition nutrition) {
        return nutritionRepository.save(nutrition);
    }

    public List<Nutrition> getAllNutritions() {
        return nutritionRepository.findAll();
    }


    public Nutrition retrieveNutrition(Long nutritionId) {
        return nutritionRepository.findById(nutritionId).get();
    }

    public Nutrition modifyNutrition(Long id, Nutrition nutrition) {
        // Vérifier si l'objet Nutrition avec l'id existe
        Optional<Nutrition> existingNutrition = nutritionRepository.findById(id);

        if (existingNutrition.isPresent()) {
            Nutrition updatedNutrition = existingNutrition.get();
            updatedNutrition.setName(nutrition.getName());
            updatedNutrition.setDescription(nutrition.getDescription());
            updatedNutrition.setMealType(nutrition.getMealType());
            updatedNutrition.setQuantity(nutrition.getQuantity());
            updatedNutrition.setCalories(nutrition.getCalories());


            return nutritionRepository.save(updatedNutrition);
        } else {
            throw new RuntimeException("Nutrition with id " + id + " not found");
        }
    }

    public void removeNutrition(Long nutritionId) {
        nutritionRepository.deleteById(nutritionId);
    }
}
