package com.smartonion.salt.service;

import com.smartonion.salt.model.ShoppingList;
import com.smartonion.salt.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingListService {

    @Autowired
    private ShoppingListRepository repository;

    public Optional<ShoppingList> getShoppingListById(String shoppingListId){
        return repository.findByShoppingListId(shoppingListId); // Update method call
    }
}
