package com.smartonion.salt.repository.ProfileRepo;

import com.smartonion.salt.model.Profile.FoodPreference; 
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodPreferenceRepo extends MongoRepository<FoodPreference, String> {
}

