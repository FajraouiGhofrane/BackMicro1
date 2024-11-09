package com.esprit.microservice.nutrition;

import java.util.List;

public interface INutritionService {

    public Nutrition addNutrition(Nutrition nutrition);


    public List<Nutrition> getAllNutritions();


    public Nutrition retrieveNutrition(Long nutritionId) ;


    public Nutrition modifyNutrition(Long id, Nutrition nutrition);

    public void removeNutrition(Long nutritionId);
}
