package com.smartonion.salt.repository.ProfileRepo;

import com.smartonion.salt.model.Profile.DietaryRestriction; 
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DietaryRestrictionRepo extends MongoRepository<DietaryRestriction, String> {
}

