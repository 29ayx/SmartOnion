package com.smartonion.salt.repository;

import com.smartonion.salt.model.FoodConsumption;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FoodConRepository extends MongoRepository<FoodConsumption, String> {

    List<FoodConsumption> findAllByFamilyId();

    List<FoodConsumption> findAllFoodConsumptionByFamilyId(String email);

    List<FoodConsumption> findAllByProfileId(String profileId);
}