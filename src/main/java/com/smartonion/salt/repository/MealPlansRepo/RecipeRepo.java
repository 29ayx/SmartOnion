package com.smartonion.salt.repository.MealPlansRepo;


import com.smartonion.salt.model.MealPlans.MealPlan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepo extends MongoRepository<MealPlan, String> {
}