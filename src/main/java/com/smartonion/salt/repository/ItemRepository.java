package com.smartonion.salt.repository;

import com.smartonion.salt.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {

}
