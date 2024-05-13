package com.smartonion.salt.repository.Inventory;

import com.smartonion.salt.model.Inventory.Fruit;
import com.smartonion.salt.model.Inventory.Vegetable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VegetableRepository extends MongoRepository<Vegetable, String> {
    // You can define custom queries here if needed
}
