package com.smartonion.salt.repository;

import com.smartonion.salt.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {

    List<Item> findByType(String type);  // Use string for type
    List<Item> findByName(String name);  // New method to find by name

    @Query("{'expiryDate': {$lt: ?0}}")
    List<Item> findExpiredItems(Date currentDate);

    @Query("{'quantity': {$lt: ?0}}")
    List<Item> findItemsWithLowStock(int threshold);
}
