package com.smartonion.salt.repository.inventory;

import com.smartonion.salt.model.inventory.Meat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MeatRepository extends MongoRepository<Meat, String> {
    // You can define custom queries here if needed
}
