package com.smartonion.salt.repository.Inventory;

import com.smartonion.salt.model.inventory.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FruitRepository extends MongoRepository<Fruit, String> {
    // You can define custom queries here if needed
}
