package com.smartonion.salt.service.ProfileService;

import com.smartonion.salt.model.Profile.FoodPreference;
import com.smartonion.salt.repository.ProfileRepo.FoodPreferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodPreferenceService {

    @Autowired
    private FoodPreferenceRepo foodPreferenceRepo;

    // CRUD Methods

    public FoodPreference createFoodPreference(FoodPreference foodPreference) {
        return foodPreferenceRepo.save(foodPreference);
    }

    public List<FoodPreference> getAllFoodPreferences() {
        return foodPreferenceRepo.findAll();
    }

    public Optional<FoodPreference> getFoodPreferenceById(String foodPreferenceId) {
        return foodPreferenceRepo.findById(foodPreferenceId);
    }

    public FoodPreference updateFoodPreference(FoodPreference foodPreference) {
        return foodPreferenceRepo.save(foodPreference);
    }

    public void deleteFoodPreference(String foodPreferenceId) {
        foodPreferenceRepo.deleteById(foodPreferenceId);
    }
}
