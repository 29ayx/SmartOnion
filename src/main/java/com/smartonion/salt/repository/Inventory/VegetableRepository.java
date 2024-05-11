package com.smartonion.salt.repository.Inventory;

import com.smartonion.salt.model.inventory.Fruit;
import com.smartonion.salt.model.inventory.Vegetable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VegetableRepository extends MongoRepository<Vegetable, String> {
    // You can define custom queries here if needed
}
