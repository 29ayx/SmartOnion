package com.smartonion.salt.repository;

import com.smartonion.salt.model.inventory.UserInventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInventoryRepository extends MongoRepository<UserInventory, String> {
    // Additional query methods (if needed) can be defined here
}
