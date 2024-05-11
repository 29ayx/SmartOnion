package com.smartonion.salt.controller;

import com.smartonion.salt.model.ShoppingList;
import com.smartonion.salt.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/shoppingList")
public class ShoppingListController {

    @Autowired
    private ShoppingListService service;

    @GetMapping("/{shoppingListId}")
    public ResponseEntity<?> getShoppingListById(@PathVariable String shoppingListId) {
        try {
            Optional<ShoppingList> optionalShoppingList = service.getShoppingListById(shoppingListId);
            if (optionalShoppingList.isPresent()) {
                ShoppingList shoppingList = optionalShoppingList.get();
                return ResponseEntity.ok(shoppingList);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }


    // Other methods...
}