package com.smartonion.salt.service.ProfileService;

import com.smartonion.salt.model.Profile.DietaryRestriction;
import com.smartonion.salt.repository.ProfileRepo.DietaryRestrictionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DietaryRestrictionService {

    @Autowired
    private DietaryRestrictionRepo dietaryRestrictionRepo;

    // CRUD Methods

    public DietaryRestriction createDietaryRestriction(DietaryRestriction dietaryRestriction) {
        return dietaryRestrictionRepo.save(dietaryRestriction);
    }

    public List<DietaryRestriction> getAllDietaryRestrictions() {
        return dietaryRestrictionRepo.findAll();
    }

    public Optional<DietaryRestriction> getDietaryRestrictionById(String dietaryRestrictionId) {
        return dietaryRestrictionRepo.findById(dietaryRestrictionId);
    }

    public DietaryRestriction updateDietaryRestriction(DietaryRestriction dietaryRestriction) {
        return dietaryRestrictionRepo.save(dietaryRestriction);
    }

    public void deleteDietaryRestriction(String dietaryRestrictionId) {
        dietaryRestrictionRepo.deleteById(dietaryRestrictionId);
    }
}

