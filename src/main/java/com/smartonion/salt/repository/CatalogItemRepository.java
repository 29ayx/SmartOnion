package com.smartonion.salt.repository;

import com.smartonion.salt.model.CatalogItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CatalogItemRepository extends MongoRepository<CatalogItem, String> {
    // This might include methods for finding catalog items by type or name if needed
}
