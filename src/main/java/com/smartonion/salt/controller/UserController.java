package com.smartonion.salt.controller;
import com.smartonion.salt.model.inventory.UserInventory;
import com.smartonion.salt.model.ShoppingList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.smartonion.salt.service.UserService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import com.smartonion.salt.model.AdminUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody AdminUser user) {
        if (service.findAdminUserByEmail(user.getEmail()) == null) {
            AdminUser createdUser = service.addUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }
    }

    @GetMapping
    public List<AdminUser> getUser(){
        return service.findAllUsers();
    }




    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String id) {
        service.deleteUserByEmail(id);
    }



    @GetMapping("/{email}")
    public AdminUser getUser(@PathVariable String email){
        return service.findAdminUserByEmail(email);
    }
    @PutMapping("/{id}")
    public AdminUser updateUser(@RequestBody AdminUser adminuser){
        return service.updateAdminUser(adminuser);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginUser(@RequestBody AdminUser user) {
        AdminUser existingUser = service.findAdminUserByEmail(user.getEmail());
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "User does not exist"));
        } else if (!existingUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("error", "Password is wrong"));
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("email", existingUser.getEmail());
            return ResponseEntity.ok(response);
        }
    }

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    //Add item to user's inventory
    @PostMapping("/{email}/additem")
    public ResponseEntity<?> addInventoryItemToUser(@PathVariable String email, @RequestBody UserInventory item) {

        //Add item to the user's inventory
        try {
            log.info("Adding inventory item to user: {}", email);
            //Checks the user exist and adds
            AdminUser updatedUser = service.addInventoryItemToUser(email, item);
            return ResponseEntity.ok(updatedUser);
            //Else throws and error
        } catch (RuntimeException ex) {
            log.error("Error adding inventory item: {}", ex.getMessage());
            return ResponseEntity.badRequest().body("Error adding inventory item: " + ex.getMessage());
        }
    }
    @PostMapping("/{email}/shoppinglist")
    public ResponseEntity<?> addShoppingList(@PathVariable String email, @RequestBody ShoppingList list) {

        //Add item to the user's inventory
        try {
            log.info("Adding inventory item to user: {}", email);
            //Checks the user exist and adds
            AdminUser updatedUser = service.addShoppingListToUser(email, list);
            return ResponseEntity.ok(updatedUser);
            //Else throws and error
        } catch (RuntimeException ex) {
            log.error("Error adding shopping list: {}", ex.getMessage());
            return ResponseEntity.badRequest().body("Error adding shopping list: " + ex.getMessage());
        }
    }

    @GetMapping("/{email}/inventory")
    public ResponseEntity<?> getAllInventoryItems(@PathVariable String email) {
        try {
            List<UserInventory> inventoryItems = service.getAllInventoryItems(email);
            if(inventoryItems.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No items available in fridge.");
            }
            else{

            return ResponseEntity.ok(inventoryItems);
            }
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No items available in fridge.");
        }
    }

    @GetMapping("/{email}/shoppinglist")
    public ResponseEntity<?> getAllShoppingList(@PathVariable String email) {
        try {
            List<ShoppingList> shoppingList = service.getAllShoppingList(email);
            return ResponseEntity.ok(shoppingList);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("/{email}/shoppinglist/{shoppingListId}")
    public ResponseEntity<?> getShoppingListForUser(@PathVariable String email, @PathVariable String shoppingListId) {
        try {
            AdminUser user = service.findAdminUserByEmail(email);
            if (user == null) {
                return ResponseEntity.notFound().build();
            }
            for (ShoppingList shoppingList : user.getShoppingList()) {
                String listId = shoppingList.getShoppingListId();
                if (listId != null && listId.equals(shoppingListId)) {
                    return ResponseEntity.ok(shoppingList);
                }
            }
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PutMapping("/{email}/shoppinglist/{shoppingListId}")
    public ResponseEntity<?> updateShoppingListForUser(@PathVariable String email, @RequestBody String shoppingListId) {
        try {
            AdminUser user = service.findAdminUserByEmail(email);
            if (user == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
