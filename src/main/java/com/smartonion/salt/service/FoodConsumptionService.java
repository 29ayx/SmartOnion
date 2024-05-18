package com.smartonion.salt.service;

import com.smartonion.salt.model.FoodConsumption;
import com.smartonion.salt.repository.FoodConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodConsumptionService {

    @Autowired
    private FoodConsumptionRepository foodConsumptionRepository;

    public List<FoodConsumption> getAllConsumptions() {
        return foodConsumptionRepository.findAll();
    }

    public List<FoodConsumption> getConsumptionsByFamilyId(String familyId) {
        return foodConsumptionRepository.findByFamilyId(familyId);
    }

    public List<FoodConsumption> getConsumptionsByProfileId(String profileId) {
        return foodConsumptionRepository.findByProfileId(profileId);
    }

    public FoodConsumption addConsumption(FoodConsumption foodConsumption) {
        return foodConsumptionRepository.save(foodConsumption);
    }
}
