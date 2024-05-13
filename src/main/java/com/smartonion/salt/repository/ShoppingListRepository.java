package com.smartonion.salt.repository;

import com.smartonion.salt.model.ShoppingList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ShoppingListRepository extends MongoRepository<ShoppingList, String> {



}
