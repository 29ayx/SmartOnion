package com.smartonion.salt.repository;


import com.smartonion.salt.model.FamilyInventory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FamilyInventoryRepository  extends MongoRepository<FamilyInventory, String> {
    List<FamilyInventory> findByFamilyId(String familyId);
}

