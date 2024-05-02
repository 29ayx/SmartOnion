package com.smartonion.salt.repository.InventoryRepo;

import com.smartonion.salt.model.Inventory.Sauce; 
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SauceRepo extends MongoRepository<Sauce, String> {
}

