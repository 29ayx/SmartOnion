package com.smartonion.salt.repository.InventoryRepo;

import com.smartonion.salt.model.Inventory.Meat; 
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MeatRepo extends MongoRepository<Meat, String> {
}

