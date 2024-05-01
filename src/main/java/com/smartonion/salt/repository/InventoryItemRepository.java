package com.smartonion.salt.repository;

import com.smartonion.salt.model.InventoryItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InventoryItemRepository extends MongoRepository<InventoryItem, String> {
    List<InventoryItem> findByItemId(String itemId);
    // Additional methods for querying based on stock status or expiry could be added here
}
