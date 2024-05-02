package com.smartonion.salt.service.MealPlansService;

import com.smartonion.salt.model.MealPlans.MealPlan;
import com.smartonion.salt.repository.MealPlansRepo.MealPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealPlanService {

    @Autowired
    private MealPlanRepo mealPlanRepo;

    // CRUD Methods

    public MealPlan createMealPlan(MealPlan mealPlan) {
        return mealPlanRepo.save(mealPlan);
    }

    public List<MealPlan> getAllMealPlans() {
        return mealPlanRepo.findAll();
    }

    public Optional<MealPlan> getMealPlanById(String mealPlanId) {
        return mealPlanRepo.findById(mealPlanId);
    }

    public MealPlan updateMealPlan(MealPlan mealPlan) {
        return mealPlanRepo.save(mealPlan);
    }

    public void deleteMealPlan(String mealPlanId) {
        mealPlanRepo.deleteById(mealPlanId);
    }
}
