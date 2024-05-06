package com.smartonion.salt.repository.Inventory;

import com.smartonion.salt.model.Inventory.Other;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OtherRepository extends MongoRepository<Other, String> {
    // Custom queries can be defined here if needed
}
