package com.smartonion.salt.repository.InventoryRepo;

import com.smartonion.salt.model.Inventory.Drink;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DrinkRepo extends MongoRepository<Drink, String> {
}
