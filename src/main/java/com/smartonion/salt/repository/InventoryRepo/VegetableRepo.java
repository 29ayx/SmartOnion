package com.smartonion.salt.repository.InventoryRepo;

import com.smartonion.salt.model.Inventory.Vegetable; 
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VegetableRepo extends MongoRepository<Vegetable, String> {
}

