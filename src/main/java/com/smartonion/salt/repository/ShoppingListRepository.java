package com.smartonion.salt.repository;

import com.smartonion.salt.model.ShoppingList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ShoppingListRepository extends MongoRepository<ShoppingList, String> {
    Optional<ShoppingList> findByShoppingListId(String shoppingListId); // Use findByShoppingListId instead of getShoppingListById
}

