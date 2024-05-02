package com.smartonion.salt.repository.InventoryRepo;

import com.smartonion.salt.model.Inventory.Other; 
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OtherRepo extends MongoRepository<Other, String> {
}

