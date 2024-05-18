package com.smartonion.salt.repository;

import com.smartonion.salt.model.inventory.UserInventory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InventoryItemRepository extends MongoRepository<UserInventory, String> {



}
