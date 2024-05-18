package com.smartonion.salt.repository;

import com.smartonion.salt.model.FoodConsumption;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FoodConsumptionRepository extends MongoRepository<FoodConsumption, String> {

    List<FoodConsumption> findAllByFamilyId();
    List<FoodConsumption> findAllByProfileId(String profileId);
    List<FoodConsumption> findByFamilyId(String familyId);
    List<FoodConsumption> findByProfileId(String profileId);
}