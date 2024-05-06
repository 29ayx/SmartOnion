package com.smartonion.salt.repository.InventoryRepo;

import com.smartonion.salt.model.Inventory.FoodItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodItemRepo extends MongoRepository<FoodItem, String> {
}