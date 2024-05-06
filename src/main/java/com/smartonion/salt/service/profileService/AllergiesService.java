package com.smartonion.salt.service.ProfileService;

import com.smartonion.salt.model.Profile.Allergies;
import com.smartonion.salt.repository.ProfileRepo.AllergiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllergiesService {

    @Autowired
    private AllergiesRepo allergiesRepo;

    // CRUD Methods

    public Allergies createAllergies(Allergies allergies) {
        return allergiesRepo.save(allergies);
    }

    public List<Allergies> getAllAllergies() {
        return allergiesRepo.findAll();
    }

    public Optional<Allergies> getAllergiesById(String allergiesId) {
        return allergiesRepo.findById(allergiesId);
    }

    public Allergies updateAllergies(Allergies allergies) {
        return allergiesRepo.save(allergies);
    }

    public void deleteAllergies(String allergiesId) {
        allergiesRepo.deleteById(allergiesId);
    }
}

